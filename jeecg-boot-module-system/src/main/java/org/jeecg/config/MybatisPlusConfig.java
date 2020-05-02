package org.jeecg.config;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.parser.ISqlParser;
import com.baomidou.mybatisplus.core.parser.ISqlParserFilter;
import com.baomidou.mybatisplus.core.parser.SqlParserHelper;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import com.baomidou.mybatisplus.extension.plugins.tenant.TenantSqlParser;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import net.sf.jsqlparser.expression.StringValue;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.config.mybatis.YDKJTenantHandler;
import org.jeecg.config.mybatis.YDKJTenantSqlParser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 单数据源配置（jeecg.datasource.open = false时生效）
 * @Author zhoujf
 *
 */
@Configuration
@MapperScan(value={"**.modules.**.mapper*"})
public class MybatisPlusConfig {
    @Value("${tenant.tentTables}")
    private String tentTables;
    /**
         *  分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        // 设置sql的limit为无限制，默认是500
//        return new PaginationInterceptor().setLimit(-1);
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        /*
         * 【测试多租户】 SQL 解析处理拦截器<br>
         * 这里固定写成住户 1 实际情况你可以从cookie读取，因此数据看不到 【 麻花藤 】 这条记录（ 注意观察 SQL ）<br>
         */
        List<ISqlParser> sqlParserList = new ArrayList<>();
        YDKJTenantSqlParser tenantSqlParser = new YDKJTenantSqlParser();

        tenantSqlParser.setTenantHandler(new YDKJTenantHandler() {
            @Override
            public boolean doUserFilter(LoginUser userInfo) {
                /**
                 * 这个参数是当前线程变量中的用户信息
                 * 当用户信息没有租户ID（超管或者未登录），即不过滤该sql
                 */

                if (ObjectUtil.isNotNull(userInfo) && ObjectUtil.isNotNull(userInfo.getTenantId())) {
                    return false;
                }
                return true;
            }

            @Override
            public Expression getTenantId() {
                /**
                 * sql解析时，租户ID参数从会话线程中取出
                 */
                if (ObjectUtil.isNotNull((LoginUser) SecurityUtils.getSubject().getPrincipal()) && ObjectUtil.isNotNull(((LoginUser) SecurityUtils.getSubject().getPrincipal()).getTenantId())) {
                    return new LongValue(((LoginUser) SecurityUtils.getSubject().getPrincipal()).getTenantId());
                }
                return null;
            }

            /**
             * 数据库各表中，租户ID字段名
             * @return
             */
            @Override
            public String getTenantIdColumn() {
                return "tenant_id";
            }

            @Override
            public boolean doTableFilter(String tableName) {
                /**
                 * 这里可以判断是否过滤表
                 * 表名根据实际去配置，凡是不带tent_id的表均应该配置，否则sql会报找不到tent_id这个字段
                 */
                if (ObjectUtil.isNotNull(tentTables)) {
                    List<String> tables = Arrays.asList(tentTables.split(","));
                    if (CollUtil.isNotEmpty(tables) && tables.contains(tableName)) {
                        return false;
                    }
                }
                return true;
            }
        });
        sqlParserList.add(tenantSqlParser);
        paginationInterceptor.setSqlParserList(sqlParserList);
        return paginationInterceptor;
    }

    /**
     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        return new PerformanceInterceptor();
    }
    
   
}
