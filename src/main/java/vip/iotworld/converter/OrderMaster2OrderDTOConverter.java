package vip.iotworld.converter;

import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import vip.iotworld.dataobject.OrderMaster;
import vip.iotworld.dto.OrderDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:30/08/2018
 * Time:09:18
 */
public class OrderMaster2OrderDTOConverter {

    public static OrderDTO convert(OrderMaster orderMaster) {

        OrderDTO orderDTO = new OrderDTO();
        BeanUtils.copyProperties(orderMaster, orderDTO);
        return orderDTO;
    }

    public static List<OrderDTO> convert(List<OrderMaster> orderMasterList){
        return orderMasterList.stream().map(e ->convert(e)).collect(Collectors.toList());
    }

    //TODO 思考?
//    public static Page<OrderDTO> convert(Page<OrderMaster> orderMasterPage){
//        Page<OrderDTO> orderDTOPage =  (Page<OrderDTO>) new  PageRequest(orderMasterPage.getNumber(), orderMasterPage.getSize());
//
//        BeanUtils.copyProperties(orderMasterPage, orderDTOPage);
//
//        return orderDTOPage;
//    }
}
