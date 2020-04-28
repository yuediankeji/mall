package org.base.modules.store_category.controller;

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
import org.base.modules.store_category.entity.MallStoreCategory;
import org.base.modules.store_category.service.IMallStoreCategoryService;

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
 * @Description: mall_store_category
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Api(tags="mall_store_category")
@RestController
@RequestMapping("/store_category/mallStoreCategory")
@Slf4j
public class MallStoreCategoryController extends JeecgController<MallStoreCategory, IMallStoreCategoryService> {
	@Autowired
	private IMallStoreCategoryService mallStoreCategoryService;
	
	/**
	 * 分页列表查询
	 *
	 * @param mallStoreCategory
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "mall_store_category-分页列表查询")
	@ApiOperation(value="mall_store_category-分页列表查询", notes="mall_store_category-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(MallStoreCategory mallStoreCategory,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<MallStoreCategory> queryWrapper = QueryGenerator.initQueryWrapper(mallStoreCategory, req.getParameterMap());
		Page<MallStoreCategory> page = new Page<MallStoreCategory>(pageNo, pageSize);
		IPage<MallStoreCategory> pageList = mallStoreCategoryService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param mallStoreCategory
	 * @return
	 */
	@AutoLog(value = "mall_store_category-添加")
	@ApiOperation(value="mall_store_category-添加", notes="mall_store_category-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody MallStoreCategory mallStoreCategory) {
		mallStoreCategoryService.save(mallStoreCategory);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param mallStoreCategory
	 * @return
	 */
	@AutoLog(value = "mall_store_category-编辑")
	@ApiOperation(value="mall_store_category-编辑", notes="mall_store_category-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody MallStoreCategory mallStoreCategory) {
		mallStoreCategoryService.updateById(mallStoreCategory);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "mall_store_category-通过id删除")
	@ApiOperation(value="mall_store_category-通过id删除", notes="mall_store_category-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		mallStoreCategoryService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "mall_store_category-批量删除")
	@ApiOperation(value="mall_store_category-批量删除", notes="mall_store_category-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.mallStoreCategoryService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "mall_store_category-通过id查询")
	@ApiOperation(value="mall_store_category-通过id查询", notes="mall_store_category-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		MallStoreCategory mallStoreCategory = mallStoreCategoryService.getById(id);
		if(mallStoreCategory==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(mallStoreCategory);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param mallStoreCategory
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, MallStoreCategory mallStoreCategory) {
        return super.exportXls(request, mallStoreCategory, MallStoreCategory.class, "mall_store_category");
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
        return super.importExcel(request, response, MallStoreCategory.class);
    }

}
