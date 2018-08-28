package vip.iotworld.service.Impl;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.iotworld.dataobject.OrderDetail;
import vip.iotworld.dto.OrderDTO;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:28/08/2018
 * Time:10:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {

    @Autowired
    private OrderServiceImpl orderService;

    private final String BUYER_OPENID = "110110";

    @Test
    public void create() {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName("莱宝");
        orderDTO.setBuyerAddress("慕课网");
        orderDTO.setBuyerPhone("12345678901");
        orderDTO.setBuyerOpenid(BUYER_OPENID);

        //购物车

        List<OrderDetail> orderDetailList = new ArrayList<>();

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setProductId("123458");
        orderDetail.setProductQuantity(1);

        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setProductId("123456");
        orderDetail1.setProductQuantity(3);

        orderDetailList.add(orderDetail);
        orderDetailList.add(orderDetail1);

        orderDTO.setOrderDetailList(orderDetailList);

        OrderDTO result = orderService.create(orderDTO);
        log.info("【创建订单】 result={}"+result);
        Assert.assertNotNull(result);

    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }

    @Test
    public void finish() {
    }

    @Test
    public void paid() {
    }
}