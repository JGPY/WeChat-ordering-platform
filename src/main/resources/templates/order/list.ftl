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
                                <th>订单id</th>
                                <th>姓名 </th>
                                <th>手机号 </th>
                                <th>地址 </th>
                                <th>金额</th>
                                <th>订单状态</th>
                                <th>支付状态</th>
                                <th>创建时间</th>
                                <th colspan="2">操作</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list orderDTOPage.content as orderDTO>
                    <tr>
                        <td>${orderDTO.orderId}</td>
                        <td>${orderDTO.buyerName}</td>
                        <td>${orderDTO.buyerPhone}</td>
                        <td>${orderDTO.buyerAddress}</td>
                        <td>${orderDTO.orderAmount}</td>
                        <td>${orderDTO.getOrderStatusEnum().getMessage()}</td>
                        <td>${orderDTO.getPayStatusEnum().getMessage()}</td>
                        <td>${orderDTO.createTime}</td>
                        <td><a href="/wechat/seller/order/detail?orderId=${orderDTO.getOrderId()}">详情</a></td>
                        <td>
                            <#if orderDTO.getOrderStatusEnum().getMessage() == "新订单">
                                <a href="/wechat/seller/order/cancel?orderId=${orderDTO.getOrderId()}">取消</a>
                            <#else>
                                已取消
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
                        <li><a href="/wechat/seller/order/list?page=${currentPage - 1}&size=${size}">上一页</a></li>
                    </#if>
                        <#--<#if orderDTOPage.getTotalPages() lte 6>-->
                            <#list 1..orderDTOPage.getTotalPages() as index>
                                <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                                <#else>
                                <li><a href="/wechat/seller/order/list?page=${index}&size=${size}">${index}</a></li>
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
                    <#if currentPage gte orderDTOPage.getTotalPages()>
                        <li class="disabled"><a href="#">下一页</a></li>
                    <#else>
                        <li><a href="/wechat/seller/order/list?page=${currentPage + 1}&size=${size}">下一页</a></li>
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