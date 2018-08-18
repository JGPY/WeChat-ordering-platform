package vip.iotworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.iotworld.dataobject.ProductInfo;

import java.util.List;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:17/08/2018
 * Time:21:00
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo, String> {

    List<ProductInfo> findByProductStatus(Integer productStatus);
}
