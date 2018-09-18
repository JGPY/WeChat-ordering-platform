<html>
    <#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">

        <#--主题类容content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <table class="table table-hover table-bordered tab-container">
                            <thead>
                            <tr>
                                <th>商品id</th>
                                <th>名称</th>
                                <th>图片</th>
                                <th>单价</th>
                                <th>库存</th>
                                <th>描述</th>
                                <th>类目</th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list productServicePage.content as productInfo>
                    <tr>
                        <td>${productInfo.productId}</td>
                        <td>${productInfo.productName}</td>
                        <td><img src="${productInfo.productIcon}" height="100" width="100" ></td>
                        <td>${productInfo.productPrice}</td>
                        <td>${productInfo.productStock}</td>
                        <td>${productInfo.productDescription}</td>
                        <td>${productInfo.categoryType}</td>
                        <td>${productInfo.createTime}</td>
                        <td>${productInfo.updateTime}</td>
                        <td><a href="/wechat/seller/product/index?productId=${productInfo.productId}">修改</a></td>
                        <td>
                            <#if productInfo.getProductStatusEnum().getMessage() == "在架">
                                <a href="/wechat/seller/product/off_seale?productId=${productInfo.productId}">下架</a>
                            <#else>
                                 <a href="/wechat/seller/product/on_seale?productId=${productInfo.productId}">在架</a>
                            </#if>
                        </td>
                    </tr>
                    </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="col-md-12 column">
                        <ul class="pagination pull-right">
                    <#if currentPage lte 1>
                        <li class="disabled"><a href="#">上一页</a></li>
                    <#else>
                        <li><a href="/wechat/seller/product/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>
                        <#--<#if orderDTOPage.getTotalPages() lte 6>-->
                            <#list 1..productServicePage.getTotalPages() as index>
                                <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                <li><a href="/wechat/seller/product/list?page=${index}&size=${size}">${index}</a></li>
                                </#if>
                            </#list>
                        <#--<#else>-->
                        <#--<#list 1..currentPage as index>-->
                        <#--<#if currentPage == index>-->
                        <#--<li class="disabled"><a href="#">${index}</a></li>-->
                        <#--<#else>-->
                        <#--<li><a href="/wechat/seller/order/list?page=${index}&size=${size}">${index}</a></li>-->
                        <#--</#if>-->
                        <#--</#list>-->
                        <#--<li>...</li>-->
                        <#--<#list orderDTOPage.getTotalPages()-1..orderDTOPage.getTotalPages() as index>-->
                        <#--<#if currentPage == index>-->
                        <#--<li class="disabled"><a href="#">${index}</a></li>-->
                        <#--<#else>-->
                        <#--<li><a href="/wechat/seller/order/list?page=${index}&size=${size}">${index}</a></li>-->
                        <#--</#if>-->
                        <#--</#list>-->
                        <#--</#if>-->
                    <#if currentPage gte productServicePage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/wechat/seller/product/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
                    </#if>
                        </ul>

                    </div>
                </div>
            </div>
        </div>
    </div>


    </body>
</html>

<#--<#list orderDTOPage.getContent() as orderDTO>-->
    <#--${orderDTO.orderId}<br>-->
<#--</#list>-->