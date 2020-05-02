package org.mall.modules.product.controller;

import java.util.Arrays;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.aspect.annotation.PermissionData;
import org.jeecg.common.system.query.QueryGenerator;
import org.mall.modules.product.entity.YdkjMallStoreCategory;
import org.mall.modules.product.service.IYdkjMallStoreCategoryService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jeecg.common.aspect.annotation.AutoLog;

 /**
 * @Description: 商品类别
 * @Author: jeecg-boot
 * @Date:   2020-04-26
 * @Version: V1.0
 */
@Api(tags="商品类别")
@RestController
@RequestMapping("/mall/ydkjMallStoreCategory")
@Slf4j
public class YdkjMallStoreCategoryController extends JeecgController<YdkjMallStoreCategory, IYdkjMallStoreCategoryService> {
	@Autowired
	private IYdkjMallStoreCategoryService ydkjMallStoreCategoryService;
	
	/**
	 * 分页列表查询
	 *
	 * @param ydkjMallStoreCategory
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	@AutoLog(value = "商品类别-分页列表查询")
	@ApiOperation(value="商品类别-分页列表查询", notes="商品类别-分页列表查询")
	@GetMapping(value = "/list")
	public Result<?> queryPageList(YdkjMallStoreCategory ydkjMallStoreCategory,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
		QueryWrapper<YdkjMallStoreCategory> queryWrapper = QueryGenerator.initQueryWrapper(ydkjMallStoreCategory, req.getParameterMap());
		Page<YdkjMallStoreCategory> page = new Page<YdkjMallStoreCategory>(pageNo, pageSize);
		IPage<YdkjMallStoreCategory> pageList = ydkjMallStoreCategoryService.page(page, queryWrapper);
		return Result.ok(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param ydkjMallStoreCategory
	 * @return
	 */
	@AutoLog(value = "商品类别-添加")
	@ApiOperation(value="商品类别-添加", notes="商品类别-添加")
	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody YdkjMallStoreCategory ydkjMallStoreCategory) {
		ydkjMallStoreCategoryService.save(ydkjMallStoreCategory);
		return Result.ok("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param ydkjMallStoreCategory
	 * @return
	 */
	@AutoLog(value = "商品类别-编辑")
	@ApiOperation(value="商品类别-编辑", notes="商品类别-编辑")
	@PutMapping(value = "/edit")
	public Result<?> edit(@RequestBody YdkjMallStoreCategory ydkjMallStoreCategory) {
		ydkjMallStoreCategoryService.updateById(ydkjMallStoreCategory);
		return Result.ok("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "商品类别-通过id删除")
	@ApiOperation(value="商品类别-通过id删除", notes="商品类别-通过id删除")
	@DeleteMapping(value = "/delete")
	public Result<?> delete(@RequestParam(name="id",required=true) String id) {
		ydkjMallStoreCategoryService.removeById(id);
		return Result.ok("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "商品类别-批量删除")
	@ApiOperation(value="商品类别-批量删除", notes="商品类别-批量删除")
	@DeleteMapping(value = "/deleteBatch")
	public Result<?> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.ydkjMallStoreCategoryService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.ok("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "商品类别-通过id查询")
	@ApiOperation(value="商品类别-通过id查询", notes="商品类别-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<?> queryById(@RequestParam(name="id",required=true) String id) {
		YdkjMallStoreCategory ydkjMallStoreCategory = ydkjMallStoreCategoryService.getById(id);
		if(ydkjMallStoreCategory==null) {
			return Result.error("未找到对应数据");
		}
		return Result.ok(ydkjMallStoreCategory);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param ydkjMallStoreCategory
    */
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, YdkjMallStoreCategory ydkjMallStoreCategory) {
        return super.exportXls(request, ydkjMallStoreCategory, YdkjMallStoreCategory.class, "商品类别");
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
        return super.importExcel(request, response, YdkjMallStoreCategory.class);
    }

}
