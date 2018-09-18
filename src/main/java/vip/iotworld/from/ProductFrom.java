package vip.iotworld.from;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:17/09/2018
 * Time:21:03
 */
@Data
public class ProductFrom {

    private String productId;

    /** 名字.*/
    private String productName;

    /** 单价.*/
    private BigDecimal productPrice;

    /** 库存.*/
    private Integer productStock;

    /** 描述.*/
    private String productDescription;

    /** 小图.*/
    private String productIcon;

    /**类目编号.*/
    private Integer categoryType;

}
