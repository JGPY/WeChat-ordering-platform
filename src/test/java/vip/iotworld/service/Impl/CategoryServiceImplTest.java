package vip.iotworld.service.Impl;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.iotworld.dataobject.ProductCategory;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:17/08/2018
 * Time:19:44
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {

    @Autowired
    CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        ProductCategory productCategory = categoryService.findOne(1);
        Assert.assertEquals(new Integer(1), productCategory.getCategoryId());
    }

    @Test
    public void finaAll() {
        List<ProductCategory> productCategoriesList = categoryService.finaAll();
        Assert.assertNotEquals(0, productCategoriesList.size());
    }

    @Test
    public void findByCategoryTypeIn() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<ProductCategory> productCategoriesList = categoryService.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0, productCategoriesList.size());
    }

    @Test
    public void save() {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setCategoryType(2);
        productCategory.setCategoryName("潮流");
        ProductCategory result = categoryService.save(productCategory);
        Assert.assertNotNull(result);
    }
}