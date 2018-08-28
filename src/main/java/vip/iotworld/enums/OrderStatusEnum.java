package vip.iotworld.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:09:17
 */
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单") ,
    FINISHED(1, "完结"),
    CANCEl(2, "已取消"),
    ;

    private  Integer code;

    private String message;

    OrderStatusEnum(Integer code, String msssage){
        this.code = code;
        this.message = msssage;
    }
}
