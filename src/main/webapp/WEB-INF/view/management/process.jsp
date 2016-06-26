<%--
  User: Xavier
  Date: 01/17/2016
  Time: 11:25
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Expense Add, Update, Delete</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/easyui/themes/black/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/easyui/themes/icon.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/common.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery.easyui.min.js"></script>
</head>
<body>
<div class="easyui-layout" data-options="fit:true">
    <div data-options="region:'west'" style="width:200px;">
        <div class="easyui-accordion" data-options="fit:true">
            <div title="Expense Management" style="padding:10px;">
                <div><a href="display">Display Monthly Expense</a></div>
            </div>
        </div>
    </div>
    <div data-options="region:'center'">
        1111
    </div>
</div>
</body>
</html>
