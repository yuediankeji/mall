package org.mall.modules.supplier.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.mall.modules.supplier.entity.YdkjSupplier;
import org.mall.modules.supplier.mapper.YdkjSupplierMapper;
import org.mall.modules.supplier.service.IYdkjSupplierService;
import org.mall.modules.tenant.entity.YdkjTenant;
import org.mall.modules.tenant.mapper.YdkjTenantMapper;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @Description: 供应商
 * @Author: jeecg-boot
 * @Date:   2020-05-07
 * @Version: V1.0
 */
@Service
public class YdkjSupplierServiceImpl extends ServiceImpl<YdkjSupplierMapper, YdkjSupplier> implements IYdkjSupplierService {

    @Resource
    private YdkjSupplierMapper ydkjSupplierMapper;

    // 查询列表
    public Page<YdkjSupplier> getList(Page<YdkjSupplier> page, @Param(Constants.WRAPPER) Wrapper<YdkjSupplier> wrapper){
        return ydkjSupplierMapper.getList(page,wrapper);
    }

    // 查询明细
    public Map<String,Object> getEntity(String id){
        return ydkjSupplierMapper.getEntity(id);
    }
}
