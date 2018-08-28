package vip.iotworld.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.iotworld.dataobject.ProductInfo;
import vip.iotworld.dto.CartDTO;
import vip.iotworld.enums.ProductStatusEnum;
import vip.iotworld.enums.ResultEnum;
import vip.iotworld.exception.WechatException;
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
    ProductInfoRepository repository;
    @Override
    public ProductInfo findOne(String productId) {
        return repository.findById(productId).get();
    }

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return repository.save(productInfo);
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {

        for ( CartDTO cartDTO: cartDTOList) {
           ProductInfo productInfo =  repository.findById(cartDTO.getProductId()).get();
           if (productInfo == null) {
               throw new WechatException(ResultEnum.PRODUCT_NOT_EXIST);
           }

            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
           if(result < 0) {
               throw new WechatException(ResultEnum.PRODUCT_STOCK_ERROR);
           }

           productInfo.setProductStock(result);

           repository.save(productInfo);
        }

    }
}
