package org.base.modules.store_category.mapper;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.Param;
import org.base.modules.store_category.entity.MallStoreCategory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * @Description: mall_store_category
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@DS("ydkj-mall")
public interface MallStoreCategoryMapper extends BaseMapper<MallStoreCategory> {

}
