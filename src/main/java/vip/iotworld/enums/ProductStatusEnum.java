package vip.iotworld.enums;

import lombok.Getter;

/**
 *
 * 商品状态
 * Created with IDEA
 * author:LiuBing
 * Date:18/08/2018
 * Time:14:49
 */
@Getter
public enum ProductStatusEnum implements CodeEnum{

    UP(0, "在架"),
    DOWN(1, "下架");

    private  Integer code;

    private String message;

    ProductStatusEnum(Integer code, String msssage){
        this.code = code;
        this.message = msssage;
    }
}
