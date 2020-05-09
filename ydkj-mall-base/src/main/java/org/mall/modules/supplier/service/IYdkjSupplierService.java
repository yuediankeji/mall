package org.mall.modules.supplier.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;
import org.mall.modules.supplier.entity.YdkjSupplier;
import com.baomidou.mybatisplus.extension.service.IService;
import org.mall.modules.tenant.entity.YdkjTenant;

import java.util.Map;

/**
 * @Description: 供应商
 * @Author: jeecg-boot
 * @Date:   2020-05-07
 * @Version: V1.0
 */
public interface IYdkjSupplierService extends IService<YdkjSupplier> {
    // 查询列表分页
    Page<YdkjSupplier> getList(Page<YdkjSupplier> page, @Param(Constants.WRAPPER) Wrapper<YdkjSupplier> wrapper);
    // 查询明细
    Map<String,Object> getEntity(String id);

}
