<html>
<#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">

            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form role="form" method="post" action="/wechat/seller/product/save" >
                            <div class="form-group">
                                <label>名称</label>
                                <input class="form-control" name="productName" value="${(productInfo.productName)!''}" type="text" />
                            </div>
                            <div class="form-group">
                                <label>价格</label>
                                <input class="form-control" name="productPrice" value="${(productInfo.productPrice)!''}" type="text" />
                            </div>
                            <div class="form-group">
                                <label>库存</label>
                                <input class="form-control" type="text" name="productStock" value="${(productInfo.productStock)!''}"/>
                            </div>
                            <div class="form-group">
                                <label>描述</label>
                                <input class="form-control" type="text" name="productDescription" value="${(productInfo.productDescription)!''}"/>
                            </div>
                            <#--TODO 图片-->
                            <div class="form-group">
                                <label>图片</label>
                                <img height="100" width="100" src="${(productInfo.productIcon)!''}" alt="">
                                <input name="productIcon" type="text" class="form-control" value="${(productInfo.productIcon)!''}""/>
                            </div>
                            <div class="form-group">
                                <label>类目</label>
                                <select name="categoryType" class="form-control">
                                    <#list productCategoryList as productCategory>
                                        <option value="${productCategory.categoryType}"
                                                <#if (productCategory.categoryType)?? &&  productCategory.categoryType == productCategory.categoryType>
                                                    selected
                                                </#if>
                                        >
                                            ${productCategory.categoryName}
                                        </option>
                                    </#list>
                                </select>
                            </div>
                            <input hidden name="productId" value="${(productInfo.productId)!''}" type="text" />
                            <button class="btn btn-default" type="submit">提交</button>
                        </form>
                    </div>
                </div>
            </div>
    </div>
    </body>
</html>