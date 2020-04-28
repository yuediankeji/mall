package org.base.modules.store_category.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: mall_store_category
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Data
@TableName("mall_store_category")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="mall_store_category对象", description="mall_store_category")
public class MallStoreCategory implements Serializable {
    private static final long serialVersionUID = 1L;

	/**商品分类表ID*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "商品分类表ID")
    private java.lang.Integer id;
	/**父id*/
	@Excel(name = "父id", width = 15)
    @ApiModelProperty(value = "父id")
    private java.lang.Integer pid;
	/**分类名称*/
	@Excel(name = "分类名称", width = 15)
    @ApiModelProperty(value = "分类名称")
    private java.lang.String cateName;
	/**排序*/
	@Excel(name = "排序", width = 15)
    @ApiModelProperty(value = "排序")
    private java.lang.Integer sort;
	/**图标*/
	@Excel(name = "图标", width = 15)
    @ApiModelProperty(value = "图标")
    private java.lang.String pic;
	/**是否推荐*/
	@Excel(name = "是否推荐", width = 15)
    @ApiModelProperty(value = "是否推荐")
    private java.lang.Integer isShow;
	/**添加时间*/
	@Excel(name = "添加时间", width = 15)
    @ApiModelProperty(value = "添加时间")
    private java.lang.Integer addTime;
	/**删除状态*/
	@Excel(name = "删除状态", width = 15)
    @ApiModelProperty(value = "删除状态")
    private java.lang.Integer isDel;
}
