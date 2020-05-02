package org.jeecg.modules.tenant.controller;

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
import org.jeecg.modules.tenant.entity.Tenant;
import org.jeecg.modules.tenant.service.ITenantService;

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
 * @Description: 租户表
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Api(tags="租户表")
@RestController
@RequestMapping("/tenant")
@Slf4j
public class TenantController extends JeecgController<Tenant, ITenantService> {
	@Autowired
	private ITenantService tenantService;
	
	/**
	 * 分页列表查询
	 *
	 * @param tenant
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "租户表-分页列表查询")
	@ApiOperation(value="租户表-分页列表查询", notes="租户表-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(Tenant tenant,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<Tenant> queryWrapper = QueryGenerator.initQueryWrapper(tenant, req.getParameterMap());
		Page<Tenant> page = new Page<Tenant>(pageNo, pageSize);
		IPage<Tenant> pageList = tenantService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param tenant
	 * @return
	 */
	@AutoLog(value = "租户表-添加")
	@ApiOperation(value="租户表-添加", notes="租户表-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody Tenant tenant) {
		tenantService.save(tenant);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param tenant
	 * @return
	 */
	@AutoLog(value = "租户表-编辑")
	@ApiOperation(value="租户表-编辑", notes="租户表-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody Tenant tenant) {
		tenantService.updateById(tenant);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "租户表-通过id删除")
	@ApiOperation(value="租户表-通过id删除", notes="租户表-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		tenantService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "租户表-批量删除")
	@ApiOperation(value="租户表-批量删除", notes="租户表-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.tenantService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "租户表-通过id查询")
	@ApiOperation(value="租户表-通过id查询", notes="租户表-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Tenant tenant = tenantService.getById(id);
		if(tenant==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(tenant);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param tenant
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, Tenant tenant) {
        return super.exportXls(request, tenant, Tenant.class, "租户表");
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
        return super.importExcel(request, response, Tenant.class);
    }

}
