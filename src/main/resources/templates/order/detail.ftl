<html>
<#include "../common/header.ftl">

<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">

    <#--主题类容content-->
        <div id="page-content-wrapper">
            <div class="container-fluid">
            <div class="col-md-4 column">
                <table class="table table-hover table-bordered tab-container">
                    <thead>
                    <tr>
                        <th>
                            订单id
                        </th>
                        <th>
                            订单总金额
                        </th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th>
                            ${orderDTO.getOrderId()}
                        </th>
                        <th>
                            ${orderDTO.getOrderAmount()}
                        </th>

                    </tr>
                    </tbody>
                </table>
            </div>
            <div class="col-md-12 column">
                <table class="table table-hover table-bordered">
                    <thead>
                    <tr>
                        <th>
                            商品id
                        </th>
                        <th>
                            商品名称
                        </th>
                        <th>
                            价格
                        </th>
                        <th>
                            数量
                        </th>
                        <th>
                            总额
                        </th>
                    </tr>
                    </thead>
                    <tbody>
                    <#list orderDTO.getOrderDetailList() as orderDetail>
                    <tr>
                        <td>
                            ${orderDetail.getDetailId()}
                        </td>
                        <td>
                            ${orderDetail.getProductName()}
                        </td>
                        <td>
                            ${orderDetail.getProductPrice()}
                        </td>
                        <td>
                            ${orderDetail.getProductQuantity()}
                        </td>
                        <td>
                            ${orderDetail.getProductQuantity() * orderDetail.getProductPrice()}
                        </td>
                    </tr>
                    </#list>
                    </tbody>
                </table>
            </div>

            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <#if orderDTO.getOrderStatusEnum().getMessage() == "新订单">
                            <a href="/wechat/seller/order/finish?orderId=${orderDTO.orderId}" class="btn btn-default btn-primary" type="button">完结订单</a>
                            <a href="/wechat/seller/order/cancel?orderId=${orderDTO.orderId}" class="btn btn-default btn-danger" type="button">取消订单</a>
                        </#if>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>