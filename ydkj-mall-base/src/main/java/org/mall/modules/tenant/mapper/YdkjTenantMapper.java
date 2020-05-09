package org.mall.modules.tenant.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.hslf.record.CString;
import org.mall.modules.tenant.entity.YdkjTenant;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * @Description: 商户
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
public interface YdkjTenantMapper extends BaseMapper<YdkjTenant> {
    // 查询列表分页
    Page<YdkjTenant> getList(Page<YdkjTenant> page, @Param(Constants.WRAPPER) Wrapper<YdkjTenant> wrapper);
    //查询明细
    Map<String,Object> getEntity(String id);
}
