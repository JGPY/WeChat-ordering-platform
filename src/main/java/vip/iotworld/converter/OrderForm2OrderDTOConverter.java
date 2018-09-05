package vip.iotworld.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import vip.iotworld.dataobject.OrderDetail;
import vip.iotworld.dto.OrderDTO;
import vip.iotworld.enums.ResultEnum;
import vip.iotworld.exception.WechatException;
import vip.iotworld.from.OrderForm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:03/09/2018
 * Time:21:39
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO converter(OrderForm orderForm) {
        Gson gson = new Gson();

        OrderDTO orderDTO = new OrderDTO();

        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e) {
            log.error("【对象转换错误】 错误， string={}", orderForm.getItems());
            throw new WechatException(ResultEnum.PARAM_ERROR);
        }

        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
