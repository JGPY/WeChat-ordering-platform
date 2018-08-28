package vip.iotworld.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vip.iotworld.dataobject.OrderDetail;

import java.util.List;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:10:15
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);

}
