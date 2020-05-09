package org.mall.modules.supplier.controller;

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
import org.mall.modules.supplier.entity.YdkjSupplier;
import org.mall.modules.supplier.service.IYdkjSupplierService;

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
 * @Description: 供应商
 * @Author: jeecg-boot
 * @Date:   2020-05-07
 * @Version: V1.0
 */
@Api(tags="供应商")
@RestController
@RequestMapping("/supplier/ydkjSupplier")
@Slf4j
public class YdkjSupplierController extends JeecgController<YdkjSupplier, IYdkjSupplierService> {
	@Autowired
	private IYdkjSupplierService ydkjSupplierService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ydkjSupplier
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "供应商-分页列表查询")
	@ApiOperation(value="供应商-分页列表查询", notes="供应商-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(YdkjSupplier ydkjSupplier,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<YdkjSupplier> queryWrapper = QueryGenerator.initQueryWrapper(ydkjSupplier, req.getParameterMap());
		Page<YdkjSupplier> page = new Page<YdkjSupplier>(pageNo, pageSize);
		IPage<YdkjSupplier> pageList = ydkjSupplierService.getList(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ydkjSupplier
	 * @return
	 */
	@AutoLog(value = "供应商-添加")
	@ApiOperation(value="供应商-添加", notes="供应商-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody YdkjSupplier ydkjSupplier) {
		ydkjSupplierService.save(ydkjSupplier);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ydkjSupplier
	 * @return
	 */
	@AutoLog(value = "供应商-编辑")
	@ApiOperation(value="供应商-编辑", notes="供应商-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody YdkjSupplier ydkjSupplier) {
		ydkjSupplierService.updateById(ydkjSupplier);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "供应商-通过id删除")
	@ApiOperation(value="供应商-通过id删除", notes="供应商-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		ydkjSupplierService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "供应商-批量删除")
	@ApiOperation(value="供应商-批量删除", notes="供应商-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ydkjSupplierService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "供应商-通过id查询")
	@ApiOperation(value="供应商-通过id查询", notes="供应商-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Map map  = ydkjSupplierService.getEntity(id);
		if(map.size()>0) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(map);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ydkjSupplier
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, YdkjSupplier ydkjSupplier) {
        return super.exportXls(request, ydkjSupplier, YdkjSupplier.class, "供应商");
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
        return super.importExcel(request, response, YdkjSupplier.class);
    }

}
