package vip.iotworld.utils;

import java.util.Random;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:28/08/2018
 * Time:09:35
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式：时间+随机数
     * @return
     *
     * */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return  System.currentTimeMillis()+String.valueOf(number);
    }
}
