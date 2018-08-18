package vip.iotworld;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger =  LoggerFactory.getLogger(LoggerTest.class);

//    @Test
//    public void Test1(){
//        logger.error("error.....");
//        logger.debug("debug...");
//        logger.info("info.....");
//    }

    @Test
    public void Test2(){

        String name = "大名";
        String password = "123456";

        log.error("error.....");
        log.debug("debug.....");
        log.info("name:"+name+"password"+password);
        log.info("name:{},password:{}",name,password);
        log.warn("warn");
    }


}
