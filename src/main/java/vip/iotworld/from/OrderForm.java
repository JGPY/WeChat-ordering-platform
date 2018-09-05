package vip.iotworld.from;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:03/09/2018
 * Time:21:18
 */
@Data
public class OrderForm {

    /** 买家姓名. */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** 买家地址. */
    @NotEmpty(message = "地址必填")
    private String address;

    /** 买家手机号. */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /** 买家微信openId.*/
    @NotEmpty(message = "openId必填")
    private String openid;

    /** 购物车.*/
    @NotEmpty(message = "购物车不能为空")
    private String items;

}
