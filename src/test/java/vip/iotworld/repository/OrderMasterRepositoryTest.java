package vip.iotworld.repository;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import vip.iotworld.dataobject.OrderMaster;

import java.math.BigDecimal;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:10:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRepositoryTest {

    @Autowired
    private OrderMasterRepository repository;

    private final String OPENID = "111";

    @Test
    public  void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123457");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("12345678901");
        orderMaster.setBuyerAddress("无力");
        orderMaster.setOrderAmount(new BigDecimal(2.5));

        OrderMaster result = repository.save(orderMaster);
        Assert.assertNotNull(result);
    }


    @Test
    public void findByBuyerOpenid() {

        PageRequest request = new PageRequest(0, 3);

        Page<OrderMaster> result= repository.findByBuyerOpenid(OPENID, request);
//        System.out.println(result.getTotalElements());
        Assert.assertNotEquals(0, result.getTotalElements());
    }
}