package org.jeecg.modules.tenant.service.impl;

import org.jeecg.modules.tenant.entity.Tenant;
import org.jeecg.modules.tenant.mapper.TenantMapper;
import org.jeecg.modules.tenant.service.ITenantService;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * @Description: 租户表
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Service
public class TenantServiceImpl extends ServiceImpl<TenantMapper, Tenant> implements ITenantService {

}
