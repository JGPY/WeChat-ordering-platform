package vip.iotworld.dto;

import lombok.Data;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:28/08/2018
 * Time:10:23
 */
@Data
public class CartDTO {

    /** 商品Id. */
    private String productId;

    /** 数量. */
    private Integer productQuantity;

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
