package vip.iotworld.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.util.Date;

/**
 * 类目
 * product_category
 * 若类名没有符合同名驼峰配置，需要在类名前注解@Table(product_category)
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    /** 类目id.*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    /** 类目名字.*/
    private String categoryName;

    /** 类目属性.*/
    private Integer categoryType;

    /** 创建时间.*/
    private Date createTime;

    /** 更新时间.*/
    private Date updateTime;

//    public Integer getCategoryId() {
//        return categoryId;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.categoryId = categoryId;
//    }
//
//    public String getCategoryName() {
//        return categoryName;
//    }
//
//    public void setCategoryName(String categoryName) {
//        this.categoryName = categoryName;
//    }
//
//    public Integer getCategoryType() {
//        return categoryType;
//    }
//
//    public void setCategoryType(Integer categoryType) {
//        this.categoryType = categoryType;
//    }
//
//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductCategory{" +
//                "categoryId=" + categoryId +
//                ", categoryName='" + categoryName + '\'' +
//                ", categoryType='" + categoryType + '\'' +
//                '}';
//    }
}
