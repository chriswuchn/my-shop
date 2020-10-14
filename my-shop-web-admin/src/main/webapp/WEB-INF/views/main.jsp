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
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 控制面板</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
</head>
<body class="hold-transition skin-blue sidebar-mini">
    <div class="wrapper">
        <jsp:include page="../includes/nav.jsp"></jsp:include>
        <!-- Left side column. contains the logo and sidebar -->
        <jsp:include page="../includes/menu.jsp"></jsp:include>
        <!-- Content Wrapper. Contains page content -->
        <div class="content-wrapper">
            <!-- Content Header (Page header) -->
            <section class="content-header">
                <h1>
                    控制面板
                    <small></small>
                </h1>
                <ol class="breadcrumb">
                    <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                    <li class="active">控制面板</li>
                </ol>
            </section>
            <!-- Main content -->
            <section class="content">
            </section>
        </div>
        <!-- /.content-wrapper -->
        <jsp:include page="../includes/copyright.jsp"></jsp:include>
    </div>
    <jsp:include page="../includes/footer.jsp"></jsp:include>
</body>
</html>
