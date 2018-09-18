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
                                <th>类目id</th>
                                <th>名字 </th>
                                <th>type </th>
                                <th>创建时间</th>
                                <th>修改时间</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                    <#list productCategoryList as productCategory>
                    <tr>
                        <td>${productCategory.categoryId}</td>
                        <td>${productCategory.categoryName}</td>
                        <td>${productCategory.categoryType}</td>
                        <td>${productCategory.createTime}</td>
                        <td>${productCategory.updateTime}</td>
                        <td><a href="/wechat/seller/category/index?categoryId=${productCategory.categoryId}">修改</a></td>

                    </tr>
                    </#list>
                            </tbody>
                        </table>
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