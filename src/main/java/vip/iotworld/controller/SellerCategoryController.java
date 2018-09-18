package vip.iotworld.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import vip.iotworld.dataobject.ProductCategory;
import vip.iotworld.exception.WechatException;
import vip.iotworld.from.CatgoryForm;
import vip.iotworld.service.CategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * 卖家类目
 * Created with IDEA
 * author:LiuBing
 * Date:17/09/2018
 * Time:22:05
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<ProductCategory> productCategoryList = categoryService.finaAll();
        map.put("productCategoryList", productCategoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "categoryId",required = false) Integer categoryId,
                              Map<String, Object> map) {
        ProductCategory productCategory = new ProductCategory();
        if (categoryId != null ) {
            productCategory = categoryService.findOne(categoryId);
            map.put("productCategory", productCategory);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * 保存/修改
     * @param catgoryForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CatgoryForm catgoryForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()){
            map.put("url","/wechat/seller/category/list");
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("common/error",map);
        }
        try {
            ProductCategory productCategory = new ProductCategory();
            if (!StringUtils.isEmpty(catgoryForm.getCategoryId())){
                //TODO 是否存在
                productCategory = categoryService.findOne(catgoryForm.getCategoryId());
            }
            BeanUtils.copyProperties(catgoryForm, productCategory);
            categoryService.save(productCategory);
        }catch (WechatException e) {
            map.put("url","/wechat/seller/category/list");
            map.put("msg",e.getMessage());
            return new ModelAndView("common/error",map);
        }

        map.put("url","/wechat/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
