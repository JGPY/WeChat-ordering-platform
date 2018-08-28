package vip.iotworld.enums;

import lombok.Getter;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:27/08/2018
 * Time:09:45
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private  Integer code;

    private String message;

    PayStatusEnum(Integer code, String msssage){
        this.code = code;
        this.message = msssage;
    }
}
