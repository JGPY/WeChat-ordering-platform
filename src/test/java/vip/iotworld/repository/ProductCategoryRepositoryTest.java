package vip.iotworld.repository;

import org.hibernate.validator.constraints.URL;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sun.plugin.javascript.navig.Array;
import vip.iotworld.dataobject.ProductCategory;

import javax.transaction.Transactional;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:16/08/2018
 * Time:14:21
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryRepositoryTest {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findOneTest() {
        ProductCategory productCategory =  repository.findById(2).get();
//        ProductCategory productCategory =  repository.getOne(2);
        System.out.println(productCategory.toString());
    }

    @Test
    @Transactional//非测试中事务注解只有在异常时才回滚，而在测试中，执行完毕直接完全回滚
    public void addOneTest() {

        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryName("女生最爱");
        productCategory.setCategoryType(3);
        ProductCategory result= repository.save(productCategory);
        Assert.assertNotNull(result);
//        Assert.assertNotEquals(null,result);
    }

    @Test
    public void updateOneTest() {

        ProductCategory productCategory = new ProductCategory();

        productCategory.setCategoryId(3);
        productCategory.setCategoryName("男生最爱");
        productCategory.setCategoryType(3);
        repository.save(productCategory);
    }

    /**持久层加入创建时间 更新时间属性后,想自动更新，需要加注注解@DynamicUpdate*/
    @Test
    public void addOneTest2() {
        ProductCategory productCategory =  repository.findById(2).get();
        productCategory.setCategoryType(2);
        repository.save(productCategory);
        System.out.println(productCategory.toString());
    }

    @Test
    public void findByCategoryTypeInTest() {
        List<Integer> list= Arrays.asList(1, 2, 3);
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(list);
        Assert.assertNotEquals(0,productCategoryList.size());
        System.out.println(productCategoryList);


    }
}