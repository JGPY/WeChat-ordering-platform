package vip.iotworld.service;

import vip.iotworld.dto.OrderDTO;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:05/09/2018
 * Time:08:37
 */
public interface BuyerService {

    //查询一个订单
    OrderDTO findOrderOne(String openid, String orderId);

    //取消订单
    OrderDTO cancelOrder(String openid, String orderId);
}
