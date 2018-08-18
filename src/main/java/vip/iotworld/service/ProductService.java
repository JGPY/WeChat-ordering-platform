package vip.iotworld.service;

import org.hibernate.validator.constraints.URL;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vip.iotworld.dataobject.ProductInfo;

import java.util.List;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:18/08/2018
 * Time:14:19
 */
public interface ProductService {

    ProductInfo findOne(String productId);

    /**
     * 查询所有在架商品列表
     * */
    List<ProductInfo> findUpAll();

    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存

    //减库存
}
