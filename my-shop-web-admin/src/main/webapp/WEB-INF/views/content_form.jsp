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
<%@ taglib prefix="sys" tagdir="/WEB-INF/tags/sys"%>
<!DOCTYPE html>
<html>
<head>
    <title>我的商城 | 内容管理</title>
    <jsp:include page="../includes/header.jsp"></jsp:include>
    <link rel="stylesheet" href="/static/assets/plugins/jQuery-ztree/css/zTreeStyle/zTreeStyle.css" type="text/css">
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
                内容管理
                <small></small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Home</a></li>
                <li class="active">控制面板</li>
            </ol>
        </section>
        <!-- Main content -->
        <section class="content">
            <div class="row">
                <div class="col-xs-12">
                    <c:if test="${baseResult != null}">
                        <div class="alert alert-${baseResult.status==200?"success":"danger"} alert-dismissible">
                            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
                            ${baseResult.message}
                        </div>
                    </c:if>
                    <div class="box box-info">
                        <div class="box-header with-border">
                            <h3 class="box-title">${tbContent.id!=null?"编辑":"新增"}内容</h3>
                        </div>
                        <form:form id="inputForm" class="form-horizontal" action="/content/save" method="post" modelAttribute="tbContent">
                            <form:hidden path="id"></form:hidden>
                            <div class="box-body">
                                <div class="form-group">
                                    <label for="categoryId" class="col-sm-2 control-label">父级类目</label>
                                    <div class="col-sm-10">
                                        <form:hidden path="categoryId"/>
                                        <input id="categoryName" class="form-control required" placeholder="请选择" readonly="true" data-toggle="modal" data-target="#modal-default">
                                    </div>
                                </div>
                            </div>
                            <!-- /.box-body -->
                            <div class="box-footer">
                                <button type="button" class="btn btn-default" Onclick="history.go(-1)">返回</button>
                                <button type="submit" class="btn btn-info pull-right">提交</button>
                            </div>
                            <!-- /.box-footer -->
                        </form:form>
                    </div>
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"></jsp:include>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>
<script src="/static/assets/plugins/jQuery-ztree/js/jquery.ztree.core.js"></script>
<%--自定义模态框--%>
<sys:modal title="请选择哈" message="<ul id='myTree' class='ztree'></ul>"/>
<script>
    $(function(){
        App.initZTree("/content/category/tree/data",["id"],function (nodes){
            var node=nodes[0];
            $("#categoryId").val(node.id);
            $("#categoryName").val(node.name);
            $("#modal-default").modal("hide");
        });

    });
</script>
</body>
</html>