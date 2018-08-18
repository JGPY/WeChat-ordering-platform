package vip.iotworld.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vip.iotworld.dataobject.ProductInfo;
import vip.iotworld.enums.ProductStatusEnum;
import vip.iotworld.repository.ProductInfoRepository;
import vip.iotworld.service.ProductService;

import java.util.List;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:18/08/2018
 * Time:14:26
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductInfoRepository productInfoRepository;
    @Override
    public ProductInfo findOne(String productId) {
        return productInfoRepository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }
}
