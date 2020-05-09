package org.mall.modules.tenant.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.mall.modules.tenant.entity.YdkjTenant;
import org.mall.modules.tenant.mapper.YdkjTenantMapper;
import org.mall.modules.tenant.service.IYdkjTenantService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @Description: 商户
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
@Service
public class YdkjTenantServiceImpl extends ServiceImpl<YdkjTenantMapper, YdkjTenant> implements IYdkjTenantService {

    @Resource
    private YdkjTenantMapper ydkjTenantMapper;
    // 查询列表
    public Page<YdkjTenant> getList(Page<YdkjTenant> page, @Param(Constants.WRAPPER) Wrapper<YdkjTenant> wrapper){
        return ydkjTenantMapper.getList(page,wrapper);
    }

    // 查询明细
    public Map<String,Object> getEntity(String id){
        return ydkjTenantMapper.getEntity(id);
    }

}
