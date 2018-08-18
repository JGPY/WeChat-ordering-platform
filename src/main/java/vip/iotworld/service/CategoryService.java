package vip.iotworld.service;

import vip.iotworld.dataobject.ProductCategory;

import java.util.List;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:17/08/2018
 * Time:14:57
 */
public interface CategoryService {

    ProductCategory findOne(Integer categoryId);

    List<ProductCategory> finaAll();

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);

}
