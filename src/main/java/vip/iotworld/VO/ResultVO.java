package vip.iotworld.VO;

import lombok.Data;

/**
 * http请求返回的最外层对象
 * Created with IDEA
 * author:LiuBing
 * Date:18/08/2018
 * Time:16:24
 */
@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultVO<T> {

    /** 错误码.*/
    private Integer code;

    /** 提示信息.*/
    private  String msg;

    /** 具体内容*/
    private T data;

}
