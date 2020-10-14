<%--
  Created by IntelliJ IDEA.
  User: DAYE
  Date: 2020/9/3
  Time: 21:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 用户详情</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="box-body">
    <table id="dataTable" class="table">
        <tbody>
        <tr>
            <td>邮箱:</td>
            <td>${tbUser.email}</td>
        </tr>
        <tr>
            <td>姓名:</td>
            <td>${tbUser.username}</td>
        </tr>
        <tr>
            <td>phone:</td>
            <td>${tbUser.phone}</td>
        </tr>
        <tr>
            <td>创建时间:</td>
            <td><fmt:formatDate value="${tbUser.created}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
        </tr>
        <tr>
            <td>更新时间:</td>
            <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate> </td>
        </tr>
        </tbody>

    </table>

</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>