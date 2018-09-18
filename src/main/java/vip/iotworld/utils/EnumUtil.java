package vip.iotworld.utils;

import vip.iotworld.enums.CodeEnum;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:07/09/2018
 * Time:21:30
 */
public class EnumUtil {

    public static<T extends CodeEnum> T getByCode(Integer code, Class<T> enumClass) {
        for (T each: enumClass.getEnumConstants()) {
            if (code.equals(each.getCode())) {
                return each;
            }
        }
        return null;
    }
}
