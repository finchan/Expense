<%--
  User: Xavier
  Date: 01/17/2016
  Time: 11:25
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Expense Add, Update, Delete</title>
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resource/easyui/themes/black/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/easyloader.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/global.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <!--1. Beginning of menu-->
    <div data-options="region:'west'" style="width:200px;">
        <div class="easyui-accordion" data-options="fit:true">
            <div title="Expense Management" style="padding:10px;">
                <div><a href="display">Display Monthly Expense</a></div>
            </div>
        </div>
    </div>
    <!--1. End of menu-->
    <!--2. Beginning of Center Content-->
    <div data-options="region:'center'">
        <!--3. Beginning of Center Content Layout - North/Center-->
        <div class="easyui-layout" data-options="fit:true">
            <!--4. Beginning of Center Layout North Part-->
            <div data-options="region:'north'" class="layout-height">
                <form:form commandName="cost" id="myForm">
                    <table class="search-panel">
                        <tr>
                            <td>
                                <label>Date: </label>
                                <form:input id="date" path="date" class="easyui-datebox" required="true"
                                            data-options="formatter: dateFormatter, parser: dateParser,
                                            validType:['exactDate[\"date\", \"startDate\", \"endDate\"]']"/>
                            </td>
                            <td>
                                <label>Start: </label>
                                <form:input id="startDate" path="startDate" class="easyui-datebox" required="true"
                                            data-options="formatter: dateFormatter, parser: dateParser,
                                            validType:['startDate[\"date\", \"startDate\", \"endDate\"]']"/>
                            </td>
                            <td>
                                <label>End: </label>
                                <form:input id="endDate" path="endDate" class="easyui-datebox" required="true"
                                            data-options="formatter: dateFormatter, parser: dateParser,
                                            validType:['endDate[\"date\", \"startDate\", \"endDate\"]']"/>
                            </td>
                            <td>
                                <label>Category: </label>
                                <form:select class="easyui-combobox" id="category" path="category" data-options="multiple:false">
                                    <option value="">--All--</option>
                                    <c:forEach items="${categories}" var="category">
                                        <option value="${category.id}">${category.name}</option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <label>Sub-Category: </label>
                                <form:select class="easyui-combobox" id="subCategory" path="subCategory" data-options="multiple:false">
                                    <option value="">--All--</option>
                                    <c:forEach items="${subCategories}" var="subCategory">
                                        <option value="${subCategory.id}">${subCategory.name}</option>
                                    </c:forEach>
                                </form:select>
                            </td>
                            <td>
                                <a href="#" class="easyui-linkbutton" id="searchExpense" data-options="iconCls:'icon-search'" style="width:80px">Search</a>
                            </td>
                            <td>
                                <a href="#" class="easyui-linkbutton" id="exportExpense" data-options="iconCls:'icon-save'" style="width:80px">Export</a>
                            </td>
                        </tr>
                    </table>
                </form:form>
            </div>
            <!--4. End of Center Layout North Part-->
            <!--5. Beginning of CenterLayout Center Part-->
            <div data-options="region:'center'">
                <table id="dg" title="Monthly Expense"
                            class="easyui-datagrid" fitColumns="true"
                            style="width:auto; height:auto"
                            data-options="rownumbers:true, singleSelect:true,
                                autoRowHeight:false, pagination:false">
                    <thead>
                        <tr>
                            <th field="id" hidden="true">Expense No</th>
                            <th field="date" formatter = "ef.ajaxDateFormatter">Date</th>
                            <th field="category" formatter = "ef.ajaxCategoryFormatter">Category</th>
                            <th field="subCategory" formatter = "ef.ajaxSubCategoryFormatter">Sub-Category</th>
                            <th field="amount" align="right" formatter="efd.currencyFormat" styler="efd.currencyStyle">Amount</th>
                            <th field="description">Description</th>
                        </tr>
                    </thead>
                </table>
            </div>
            <!--5. End of CenterLayout Center Part-->
        </div>
        <!--3. End of Center Content Layout - North/Center-->
    </div>
    <!--2. End of Center Content-->
</div>
<script type="text/javascript">
    window.onload = function() {
        ebe.click('searchExpense');

        //To get current date daily expense
        var triggerClickButton = "${initializeFlag}";
        if( triggerClickButton == "true") {
            $('#searchExpense').trigger('click');
        }
    };
</script>
</body>
</html>
