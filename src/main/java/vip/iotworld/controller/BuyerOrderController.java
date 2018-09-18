package vip.iotworld.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import vip.iotworld.VO.ResultVO;
import vip.iotworld.converter.OrderForm2OrderDTOConverter;
import vip.iotworld.dto.OrderDTO;
import vip.iotworld.enums.ResultEnum;
import vip.iotworld.exception.WechatException;
import vip.iotworld.from.OrderForm;
import vip.iotworld.service.BuyerService;
import vip.iotworld.service.Impl.OrderServiceImpl;
import vip.iotworld.utils.ResultVOUtils;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:03/09/2018
 * Time:21:07
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {

    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    BuyerService buyerService;

    /**
     * 创建订单
     * @param orderForm
     * @param bindingResult
     * @return
     */
    @RequestMapping("/create")
    public ResultVO<Map<String, String>> create(@Valid OrderForm orderForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            log.error("【创建订单】参数不正确，orderForm={}", orderForm);
            throw new WechatException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }

        OrderDTO orderDTO = OrderForm2OrderDTOConverter.converter(orderForm);
        if (CollectionUtils.isEmpty(orderDTO.getOrderDetailList())) {
            log.error("【创建订单】");
            throw new WechatException(ResultEnum.CART_EMPTY);
        }

        OrderDTO createResult = orderService.create(orderDTO);

        Map<String, String> map = new HashMap<>();
        map.put("orderId", createResult.getOrderId());

        return ResultVOUtils.success(map);
    }

    /**
     * 订单列表
     * @param openid
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/list")
    public ResultVO<List<OrderDTO>> list(@RequestParam(value = "openid") String openid,
                                              @RequestParam(value = "page", defaultValue = "0") Integer page,
                                              @RequestParam(value = "size", defaultValue = "10") Integer size
                                              ) {
        if (StringUtils.isEmpty(openid)) {
            log.error("【订单查询列表】 openid为空");
            throw new WechatException(ResultEnum.PARAM_ERROR);
        }

        Pageable pageRequest =new PageRequest(page, size);
        Page<OrderDTO> orderDTOPage= orderService.findList(openid, pageRequest);

        //转存 Date -> Long
        
        return ResultVOUtils.success(orderDTOPage.getContent());
    }

    /**
     * 订单详情
     * @param openid
     * @param orderId
     * @return
     */
    @RequestMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderId) {
//        //不安全的做法
//        OrderDTO orderDTO = orderService.findOne(orderId);
//
//        return  ResultVOUtils.success(orderDTO);

        OrderDTO orderDTO = buyerService.findOrderOne(openid, orderId);

        return ResultVOUtils.success(orderDTO);
    }

    /**
     * 取消订单
     * @param openid
     * @param orderId
     * @return
     */
    @RequestMapping("cancel")
    public ResultVO<OrderDTO> cancel(@RequestParam("openid") String openid,
                                     @RequestParam("orderid") String orderId) {
//        //不安全的做法
//        OrderDTO orderDTO = orderService.findOne(orderId);
//        orderService.cancel(orderDTO);
//
//        return ResultVOUtils.success();

        buyerService.cancelOrder(openid, orderId);

        return  ResultVOUtils.success();
    }
}
