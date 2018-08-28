package vip.iotworld.service.Impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vip.iotworld.dataobject.OrderDetail;
import vip.iotworld.dataobject.OrderMaster;
import vip.iotworld.dataobject.ProductInfo;
import vip.iotworld.dto.CartDTO;
import vip.iotworld.dto.OrderDTO;
import vip.iotworld.enums.OrderStatusEnum;
import vip.iotworld.enums.PayStatusEnum;
import vip.iotworld.enums.ResultEnum;
import vip.iotworld.exception.WechatException;
import vip.iotworld.repository.OrderDetailRepository;
import vip.iotworld.repository.OrderMasterRepository;
import vip.iotworld.service.OrderService;
import vip.iotworld.service.ProductService;
import vip.iotworld.utils.KeyUtil;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:14:05
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    @Transactional
    public OrderDTO create(OrderDTO orderDTO) {

        String orderId = KeyUtil.genUniqueKey();
//        BigDecimal orderAmount = new BigDecimal(0);
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
//        List<CartDTO> cartDTOList = new ArrayList<>();


        //1.查询商品（数量， 价格）
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            ProductInfo productInfo = productService.findOne(orderDetail.getProductId());
            if (productInfo == null) {
                throw new WechatException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            //判断数量是否做够（通过第四步扣库存去做）
            //2.计算总价
            orderAmount = productInfo.getProductPrice()
                    .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                    .add(orderAmount);
            //订单详情入库
            orderDetail.setDetailId(KeyUtil.genUniqueKey());
            orderDetail.setOrderId(orderId);
            BeanUtils.copyProperties(productInfo, orderDetail);
            orderDetailRepository.save(orderDetail);

//            CartDTO cartDTO = new CartDTO(orderDetail.getProductId(),orderDetail.getProductQuantity());
//            cartDTOList.add(cartDTO);
        }

        //3.写入订单数据库（OrderMaster和OrderDetail）
        OrderMaster orderMaster = new OrderMaster();
        BeanUtils.copyProperties(orderDTO, orderMaster);//null也会被拷贝，需先拷贝后设置值
        orderMaster.setOrderId(orderId);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        //4.如果下单成功 扣库存
        List<CartDTO> cartDTOList = orderDTO.getOrderDetailList().stream().map(e ->
                new CartDTO(e.getProductId(), e.getProductQuantity())
                ).collect(Collectors.toList());

        productService.decreaseStock(cartDTOList);

        return orderDTO;
    }

    @Override
    public OrderDTO findOne(String OpenId) {
        return null;
    }

    @Override
    public Page<OrderDTO> findList(String buyerOpenId, Pageable pageable) {
        return null;
    }

    @Override
    public OrderDTO cancel(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO finish(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO paid(OrderDTO orderDTO) {
        return null;
    }
}
