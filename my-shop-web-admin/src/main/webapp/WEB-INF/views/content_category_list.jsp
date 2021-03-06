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
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/css/jquery.treetable.css" />
    <link rel="stylesheet" href="/static/assets/plugins/treeTable/themes/css/jquery.treetable.theme.default.css"/>
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

                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">分类列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="#" type="button" class="btn btn-sm  btn-default"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm  btn-default"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;
                            <a href="/user/delete" type="button" class="btn btn-sm  btn-default"><i class="fa fa-upload"></i>导出</a>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table class="table table-hover" id="treeTable">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>名称</th>
                                    <th>排序</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${tbContentCategories}" var="tbContentCategory">
                                        <tr data-tt-id="${tbContentCategory.id}" data-tt-parent-id ="${tbContentCategory.parentId}">
                                            <td>${tbContentCategory.id}</td>
                                            <td>${tbContentCategory.name}</td>
                                            <td>${tbContentCategory.sortOrder}</td>
                                            <td><a href="#" type="button" class="btn btn-sm btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp;&nbsp;&nbsp;
                                                <button type="button" class="btn btn-sm btn-danger"><i class="fa fa-trash-o">删除</i></button>&nbsp;&nbsp;&nbsp;
                                                <a href="#" type="button" class="btn btn-sm btn-default"><i class="fa fa-plus">新增下级菜单</i></a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table>
                        </div>
                        <!-- /.box-body -->
                    </div>
                    <!-- /.box -->
                </div>
            </div>
        </section>
    </div>
    <!-- /.content-wrapper -->
    <jsp:include page="../includes/copyright.jsp"></jsp:include>
</div>
<jsp:include page="../includes/footer.jsp"></jsp:include>
<script src="/static/assets/plugins/treeTable/themes/jquery.treetable.js"></script>
<sys:modal/>
<script>
    $(function(){
        $("#treeTable").treetable({
            expendLevel:2,//默认展开层数
            column:1,//第一列开始转换成 数状结构
            expandable:true,//可以选定展开,默认为false,无法点击
            stringExpand:"展开",//国际化
            stringCollapse:"收起",//国际化
        });
    });
</script>

</body>
</html>