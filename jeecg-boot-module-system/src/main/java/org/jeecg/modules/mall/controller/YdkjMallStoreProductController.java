package org.jeecg.modules.mall.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.mall.entity.YdkjMallStoreProduct;
import org.jeecg.modules.mall.service.IYdkjMallStoreProductService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: ydkj_mall_store_product
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Api(tags="ydkj_mall_store_product")
@RestController
@RequestMapping("/org.jeecg.modules/ydkjMallStoreProduct")
@Slf4j
public class YdkjMallStoreProductController extends JeecgController<YdkjMallStoreProduct, IYdkjMallStoreProductService> {
	@Autowired
	private IYdkjMallStoreProductService ydkjMallStoreProductService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ydkjMallStoreProduct
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "ydkj_mall_store_product-分页列表查询")
	@ApiOperation(value="ydkj_mall_store_product-分页列表查询", notes="ydkj_mall_store_product-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(YdkjMallStoreProduct ydkjMallStoreProduct,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<YdkjMallStoreProduct> queryWrapper = QueryGenerator.initQueryWrapper(ydkjMallStoreProduct, req.getParameterMap());
		Page<YdkjMallStoreProduct> page = new Page<YdkjMallStoreProduct>(pageNo, pageSize);
		IPage<YdkjMallStoreProduct> pageList = ydkjMallStoreProductService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ydkjMallStoreProduct
	 * @return
	 */
	@AutoLog(value = "ydkj_mall_store_product-添加")
	@ApiOperation(value="ydkj_mall_store_product-添加", notes="ydkj_mall_store_product-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody YdkjMallStoreProduct ydkjMallStoreProduct) {
		ydkjMallStoreProductService.save(ydkjMallStoreProduct);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ydkjMallStoreProduct
	 * @return
	 */
	@AutoLog(value = "ydkj_mall_store_product-编辑")
	@ApiOperation(value="ydkj_mall_store_product-编辑", notes="ydkj_mall_store_product-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody YdkjMallStoreProduct ydkjMallStoreProduct) {
		ydkjMallStoreProductService.updateById(ydkjMallStoreProduct);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "ydkj_mall_store_product-通过id删除")
	@ApiOperation(value="ydkj_mall_store_product-通过id删除", notes="ydkj_mall_store_product-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		ydkjMallStoreProductService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "ydkj_mall_store_product-批量删除")
	@ApiOperation(value="ydkj_mall_store_product-批量删除", notes="ydkj_mall_store_product-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ydkjMallStoreProductService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "ydkj_mall_store_product-通过id查询")
	@ApiOperation(value="ydkj_mall_store_product-通过id查询", notes="ydkj_mall_store_product-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		YdkjMallStoreProduct ydkjMallStoreProduct = ydkjMallStoreProductService.getById(id);
		if(ydkjMallStoreProduct==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(ydkjMallStoreProduct);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ydkjMallStoreProduct
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, YdkjMallStoreProduct ydkjMallStoreProduct) {
        return super.exportXls(request, ydkjMallStoreProduct, YdkjMallStoreProduct.class, "ydkj_mall_store_product");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, YdkjMallStoreProduct.class);
    }

}
