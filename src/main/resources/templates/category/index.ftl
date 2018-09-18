<html>
<#include "../common/header.ftl">
    <body>

    <div id="wrapper" class="toggled">
        <#--边栏sidebar-->
        <#include "../common/nav.ftl">

            <div class="container">
                <div class="row clearfix">
                    <div class="col-md-12 column">
                        <form role="form" method="post" action="/wechat/seller/category/save" >
                            <div class="form-group">
                                <label>名字</label>
                                <input class="form-control" name="categoryName" value="${(productCategory.categoryName)!''}" type="text" />
                            </div>
                            <div class="form-group">
                                <label>type</label>
                                <input class="form-control" type="number" name="categoryType" value="${(productCategory.categoryType)!''}"/>
                            </div>

                            <input hidden name="categoryId" value="${(productCategory.categoryId)!''}" type="text" />
                            <button class="btn btn-default" type="submit">保存</button>
                        </form>
                    </div>
                </div>
            </div>
    </div>
    </body>
</html>