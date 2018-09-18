package vip.iotworld.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import vip.iotworld.dataobject.ProductCategory;
import vip.iotworld.dataobject.ProductInfo;
import vip.iotworld.exception.WechatException;
import vip.iotworld.from.ProductFrom;
import vip.iotworld.service.CategoryService;
import vip.iotworld.service.ProductService;
import vip.iotworld.utils.KeyUtil;

import java.util.List;
import java.util.Map;

/**
 * 卖家商品端
 * Created with IDEA
 * author:LiuBing
 * Date:13/09/2018
 * Time:18:47
 */
@Controller
@RequestMapping("/seller/product")
@Slf4j
public class SellerProducterController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    /**
     * 商品列表
     * @param page
     * @param size
     * @param map
     * @return
     */
    @RequestMapping("/list")
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                  @RequestParam(value = "size", defaultValue = "10") Integer size,
                                  Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productServicePage = productService.findAll(pageRequest);
        map.put("productServicePage", productServicePage);
        map.put("currentPage", page);
        map.put("size", size);

        return new ModelAndView("product/list", map);
    }

    /**
     * 下架商品
     * @param productId
     * @param map
     * @return
     */
    //TODO 跳回修改页
    @RequestMapping("off_seale")
    public ModelAndView off_seale(@RequestParam("productId") String productId,
                                  Map<String, Object> map) {
        try {
            ProductInfo productInfo = productService.offSale(productId);
        } catch (WechatException e){
            log.error("【上架商品】,{} orderId={}",e.getMessage(), productId);
            map.put("url","/wechat/seller/product/list");
            map.put("msg",e.getMessage());
            return new ModelAndView("common/error",map);
        }

        map.put("url","/wechat/seller/product/list");
        map.put("msg","上架成功");
        return new ModelAndView("common/success",map);
    }

    /**
     * 上架商品
     * @param productId
     * @param map
     * @return
     */
    //TODO 跳回修改页
    @RequestMapping("on_seale")
    public ModelAndView on_seale(@RequestParam("productId") String productId,
                                  Map<String, Object> map) {
        try {
            ProductInfo productInfo = productService.onSale(productId);
        } catch (WechatException e){
            log.error("【上架商品】,{} orderId={}",e.getMessage(), productId);
            map.put("url","/wechat/seller/product/list");
            map.put("msg",e.getMessage());
            return new ModelAndView("common/error",map);
        }

        map.put("url","/wechat/seller/product/list");
        map.put("msg","上架成功");
        return new ModelAndView("common/success",map);
    }

    @RequestMapping("index")
    public ModelAndView index(@RequestParam(value = "productId",required = false) String productId,
                                 Map<String, Object> map) {
        if (!StringUtils.isEmpty(productId)) {
           ProductInfo productInfo = productService.findOne(productId);
           map.put("productInfo", productInfo);
        }
        //查询所有类目
        List<ProductCategory> productCategoryList = categoryService.finaAll();
           map.put("productCategoryList", productCategoryList);
        return new ModelAndView("product/index",map);
    }

    /**
     * 保存/更新
     * @param productFrom
     * @param bindingResult
     * @param map
     * @return
     */
    @RequestMapping(value = "save",method = RequestMethod.POST)
    public ModelAndView save(@Validated ProductFrom productFrom,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("url","/wechat/seller/product/index");
            map.put("msg",bindingResult.getFieldError().getDefaultMessage());
            return new ModelAndView("common/error",map);
        }


        try {
            ProductInfo productInfo = new ProductInfo();
            //如果productId为空， 说明是新增
            if (!StringUtils.isEmpty(productFrom.getProductId())){
                //TODO 判断是否存在
                productInfo = productService.findOne(productFrom.getProductId());
            }else {
                productFrom.setProductId(KeyUtil.genUniqueKey());
            }
            BeanUtils.copyProperties(productFrom, productInfo);
            productService.save(productInfo);
        } catch (WechatException e){
            map.put("url","/wechat/seller/product/index");
            map.put("msg",e.getMessage());
            return new ModelAndView("common/error",map);
        }

        map.put("url","/wechat/seller/product/list");
        return new ModelAndView("common/success", map);

    }
}
