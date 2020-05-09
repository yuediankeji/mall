package org.mall.modules.tenant.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import javafx.scene.control.Pagination;
import org.apache.ibatis.annotations.Param;
import org.mall.modules.tenant.entity.YdkjTenant;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * @Description: 商户
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
public interface IYdkjTenantService extends IService<YdkjTenant> {
    // 查询列表分页
    Page<YdkjTenant> getList(Page<YdkjTenant> page, @Param(Constants.WRAPPER) Wrapper<YdkjTenant> wrapper);
    // 查询明细
    Map<String,Object> getEntity(String id);
}
