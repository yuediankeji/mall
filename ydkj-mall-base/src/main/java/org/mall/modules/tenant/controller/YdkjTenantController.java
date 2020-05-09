package org.mall.modules.tenant.controller;

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
import org.mall.modules.tenant.entity.YdkjTenant;
import org.mall.modules.tenant.service.IYdkjTenantService;

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
 * @Description: 商户
 * @Author: jeecg-boot
 * @Date:   2020-05-06
 * @Version: V1.0
 */
@Api(tags="商户")
@RestController
@RequestMapping("/org.mall.modules/ydkjTenant")
@Slf4j
public class YdkjTenantController extends JeecgController<YdkjTenant, IYdkjTenantService> {
	@Autowired
	private IYdkjTenantService ydkjTenantService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ydkjTenant
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "商户-分页列表查询")
	@ApiOperation(value="商户-分页列表查询", notes="商户-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(YdkjTenant ydkjTenant,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<YdkjTenant> queryWrapper = QueryGenerator.initQueryWrapper(ydkjTenant, req.getParameterMap());
		Page<YdkjTenant> page = new Page<YdkjTenant>(pageNo, pageSize);
		IPage<YdkjTenant> pageList = ydkjTenantService.getList(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ydkjTenant
	 * @return
	 */
	@AutoLog(value = "商户-添加")
	@ApiOperation(value="商户-添加", notes="商户-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody YdkjTenant ydkjTenant) {
		ydkjTenantService.save(ydkjTenant);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ydkjTenant
	 * @return
	 */
	@AutoLog(value = "商户-编辑")
	@ApiOperation(value="商户-编辑", notes="商户-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody YdkjTenant ydkjTenant) {
		ydkjTenantService.updateById(ydkjTenant);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "商户-通过id删除")
	@ApiOperation(value="商户-通过id删除", notes="商户-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		ydkjTenantService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "商户-批量删除")
	@ApiOperation(value="商户-批量删除", notes="商户-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ydkjTenantService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "商户-通过id查询")
	@ApiOperation(value="商户-通过id查询", notes="商户-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		Map map = ydkjTenantService.getEntity(id);
		if(map.size()>0) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(map);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ydkjTenant
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, YdkjTenant ydkjTenant) {
        return super.exportXls(request, ydkjTenant, YdkjTenant.class, "商户");
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
        return super.importExcel(request, response, YdkjTenant.class);
    }

}
