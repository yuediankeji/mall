package org.jeecg.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.tenant.TenantHandler;
import org.jeecg.common.system.vo.LoginUser;

public interface YDKJTenantHandler  extends TenantHandler {
    boolean doUserFilter(LoginUser userInfo);
}