package vip.iotworld.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vip.iotworld.dto.OrderDTO;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:13:35
 */
public interface OrderService {

    /** 创建订单.*/
    OrderDTO create(OrderDTO orderDTO);

    /** 查询单个订单. */
    OrderDTO findOne(String OrderId);

    /** 查询订单列表. */
    Page<OrderDTO> findList(String buyerOpenId, Pageable pageable);

    /** 取消订单. */
    OrderDTO cancel(OrderDTO orderDTO);

    /** 完结订单. */
    OrderDTO finish(OrderDTO orderDTO);

    /** 支付订单. */
    OrderDTO payid(OrderDTO orderDTO);

}
