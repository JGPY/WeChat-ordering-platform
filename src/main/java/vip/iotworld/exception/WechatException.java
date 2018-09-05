package vip.iotworld.exception;

import vip.iotworld.enums.ResultEnum;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:28/08/2018
 * Time:08:45
 */
public class WechatException extends RuntimeException{

    private Integer code;

    public WechatException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());

        this.code = resultEnum.getCode();
    }

    public WechatException(Integer code,String message) {
        super(message);
        this.code = code;
    }

}
