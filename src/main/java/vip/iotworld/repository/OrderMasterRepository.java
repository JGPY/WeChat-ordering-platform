package vip.iotworld.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vip.iotworld.dataobject.OrderMaster;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:10:10
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {

    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);//不插入pageable话就会把某人的所有订单查出来了。

}
