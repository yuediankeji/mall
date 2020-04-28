package org.mall.base.modules.product.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: ydkj_mall_store_product
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Data
@TableName("ydkj_mall_store_product")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ydkj_mall_store_product对象", description="ydkj_mall_store_product")
public class YdkjMallStoreProduct implements Serializable {
    private static final long serialVersionUID = 1L;

	/**商品id*/
	@TableId(type = IdType.ID_WORKER_STR)
    @ApiModelProperty(value = "商品id")
    private java.lang.Integer id;
	/**商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)*/
	@Excel(name = "商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)", width = 15)
    @ApiModelProperty(value = "商户Id(0为总后台管理员创建,不为0的时候是商户后台创建)")
    private java.lang.Integer merId;
	/**商品图片*/
	@Excel(name = "商品图片", width = 15)
    @ApiModelProperty(value = "商品图片")
    private java.lang.String image;
	/**轮播图*/
	@Excel(name = "轮播图", width = 15)
    @ApiModelProperty(value = "轮播图")
    private java.lang.String sliderImage;
	/**商品名称*/
	@Excel(name = "商品名称", width = 15)
    @ApiModelProperty(value = "商品名称")
    private java.lang.String storeName;
	/**商品简介*/
	@Excel(name = "商品简介", width = 15)
    @ApiModelProperty(value = "商品简介")
    private java.lang.String storeInfo;
	/**关键字*/
	@Excel(name = "关键字", width = 15)
    @ApiModelProperty(value = "关键字")
    private java.lang.String keyword;
	/**产品条码（一维码）*/
	@Excel(name = "产品条码（一维码）", width = 15)
    @ApiModelProperty(value = "产品条码（一维码）")
    private java.lang.String barCode;
	/**分类id*/
	@Excel(name = "分类id", width = 15)
    @ApiModelProperty(value = "分类id")
    private java.lang.String cateId;
	/**商品价格*/
	@Excel(name = "商品价格", width = 15)
    @ApiModelProperty(value = "商品价格")
    private java.math.BigDecimal price;
	/**会员价格*/
	@Excel(name = "会员价格", width = 15)
    @ApiModelProperty(value = "会员价格")
    private java.math.BigDecimal vipPrice;
	/**市场价*/
	@Excel(name = "市场价", width = 15)
    @ApiModelProperty(value = "市场价")
    private java.math.BigDecimal otPrice;
	/**邮费*/
	@Excel(name = "邮费", width = 15)
    @ApiModelProperty(value = "邮费")
    private java.math.BigDecimal postage;
	/**单位名*/
	@Excel(name = "单位名", width = 15)
    @ApiModelProperty(value = "单位名")
    private java.lang.String unitName;
	/**排序*/
	@Excel(name = "排序", width = 15)
    @ApiModelProperty(value = "排序")
    private java.lang.Integer sort;
	/**销量*/
	@Excel(name = "销量", width = 15)
    @ApiModelProperty(value = "销量")
    private java.lang.Integer sales;
	/**库存*/
	@Excel(name = "库存", width = 15)
    @ApiModelProperty(value = "库存")
    private java.lang.Integer stock;
	/**状态（0：未上架，1：上架）*/
	@Excel(name = "状态（0：未上架，1：上架）", width = 15)
    @ApiModelProperty(value = "状态（0：未上架，1：上架）")
    private java.lang.Integer isShow;
	/**是否热卖*/
	@Excel(name = "是否热卖", width = 15)
    @ApiModelProperty(value = "是否热卖")
    private java.lang.Integer isHot;
	/**是否优惠*/
	@Excel(name = "是否优惠", width = 15)
    @ApiModelProperty(value = "是否优惠")
    private java.lang.Integer isBenefit;
	/**是否精品*/
	@Excel(name = "是否精品", width = 15)
    @ApiModelProperty(value = "是否精品")
    private java.lang.Integer isBest;
	/**是否新品*/
	@Excel(name = "是否新品", width = 15)
    @ApiModelProperty(value = "是否新品")
    private java.lang.Integer isNew;
	/**产品描述*/
	@Excel(name = "产品描述", width = 15)
    @ApiModelProperty(value = "产品描述")
    private java.lang.String description;
	/**添加时间*/
	@Excel(name = "添加时间", width = 15)
    @ApiModelProperty(value = "添加时间")
    private java.lang.Integer addTime;
	/**是否包邮*/
	@Excel(name = "是否包邮", width = 15)
    @ApiModelProperty(value = "是否包邮")
    private java.lang.Integer isPostage;
	/**是否删除*/
	@Excel(name = "是否删除", width = 15)
    @ApiModelProperty(value = "是否删除")
    private java.lang.Integer isDel;
	/**商户是否代理 0不可代理1可代理*/
	@Excel(name = "商户是否代理 0不可代理1可代理", width = 15)
    @ApiModelProperty(value = "商户是否代理 0不可代理1可代理")
    private java.lang.Integer merUse;
	/**获得积分*/
	@Excel(name = "获得积分", width = 15)
    @ApiModelProperty(value = "获得积分")
    private java.math.BigDecimal giveIntegral;
	/**成本价*/
	@Excel(name = "成本价", width = 15)
    @ApiModelProperty(value = "成本价")
    private java.math.BigDecimal cost;
	/**秒杀状态 0 未开启 1已开启*/
	@Excel(name = "秒杀状态 0 未开启 1已开启", width = 15)
    @ApiModelProperty(value = "秒杀状态 0 未开启 1已开启")
    private java.lang.Integer isSeckill;
	/**砍价状态 0未开启 1开启*/
	@Excel(name = "砍价状态 0未开启 1开启", width = 15)
    @ApiModelProperty(value = "砍价状态 0未开启 1开启")
    private java.lang.Integer isBargain;
	/**是否优品推荐*/
	@Excel(name = "是否优品推荐", width = 15)
    @ApiModelProperty(value = "是否优品推荐")
    private java.lang.Integer isGood;
	/**虚拟销量*/
	@Excel(name = "虚拟销量", width = 15)
    @ApiModelProperty(value = "虚拟销量")
    private java.lang.Integer ficti;
	/**浏览量*/
	@Excel(name = "浏览量", width = 15)
    @ApiModelProperty(value = "浏览量")
    private java.lang.Integer browse;
	/**产品二维码地址(用户小程序海报)*/
	@Excel(name = "产品二维码地址(用户小程序海报)", width = 15)
    @ApiModelProperty(value = "产品二维码地址(用户小程序海报)")
    private java.lang.String codePath;
	/**淘宝京东1688类型*/
	@Excel(name = "淘宝京东1688类型", width = 15)
    @ApiModelProperty(value = "淘宝京东1688类型")
    private java.lang.String soureLink;
}
