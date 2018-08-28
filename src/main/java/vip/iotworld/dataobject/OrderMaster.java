package vip.iotworld.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.transaction.annotation.Transactional;
import vip.iotworld.enums.OrderStatusEnum;
import vip.iotworld.enums.PayStatusEnum;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:08:55
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

    /** 订单. */
    @Id
    private String orderId;

    /** 买家姓名. */
    private String buyerName;

    /** 买家电话. */
    private String buyerPhone;

    /** 买家地址. */
    private String buyerAddress;

    /** 买家微信ID. */
    private String buyerOpenid;

    /** 订单总额. */
    private BigDecimal orderAmount;

    /** 订单状态，默认0为新下单.*/
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /** 支付状态，默认为0未支付. */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    /** 创建时间.*/
    private Date createTime;

    /** 更新时间.*/
    private Date updateTime;

//    @Transient
//    private List<OrderDetail> orderDetailList;
}
