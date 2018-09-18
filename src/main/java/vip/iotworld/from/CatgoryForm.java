package vip.iotworld.from;

import lombok.Data;

/**
 * Created with IDEA
 * author:LiuBing
 * Date:18/09/2018
 * Time:07:21
 */
@Data
public class CatgoryForm {

    /** 类目id.*/
    private Integer categoryId;

    /** 类目名字.*/
    private String categoryName;

    /** 类目属性.*/
    private Integer categoryType;
}
