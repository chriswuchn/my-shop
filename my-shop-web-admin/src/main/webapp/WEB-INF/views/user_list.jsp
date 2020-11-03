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
                用户管理
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
                    <div class="box box-info box-info-search" style="display:none;">
                        <div class="box-header">
                            <h3 class="box-title">高级搜索</h3>
                        </div>
                        <div class="box-body">
                            <div class="row form-horizontal">
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="username" class="col-sm-4 control-label">姓名</label>
                                        <div class="col-sm-8">
                                            <input id="username" Class="form-control" placeholder="姓名"></input>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="email" class="col-sm-4 control-label">邮箱</label>
                                        <div class="col-sm-8">
                                            <input id="email" cssClass="form-control" placeholder="邮箱"></input>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-xs-12 col-sm-3">
                                    <div class="form-group">
                                        <label for="phone" class="col-sm-4 control-label">手机</label>
                                        <div class="col-sm-8">
                                            <input id="phone" cssClass="form-control" placeholder="手机"></input>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="box-footer">
                            <button type="button" class="btn btn-info pull-right" onclick="search();">搜索</button>
                        </div>
                    </div>


                    <div class="box">
                        <div class="box-header">
                            <h3 class="box-title">用户列表</h3>
                        </div>
                        <div class="box-body">
                            <a href="/user/form" type="button" class="btn btn-sm  btn-default"><i class="fa fa-plus"></i>新增</a>&nbsp;&nbsp;
                            <button class="btn btn-sm  btn-default" onclick="App.deleteMutil('/user/delete')"><i class="fa fa-trash"></i>删除</button>&nbsp;&nbsp;
                            <a href="#" type="button" class="btn btn-sm  btn-default"><i class="fa fa-download"></i>导入</a>&nbsp;&nbsp;
                            <a href="/user/delete" type="button" class="btn btn-sm  btn-default"><i class="fa fa-upload"></i>导出</a>
                            <button class="btn btn-sm btn-primary" onclick="$('.box-info-search').css('display')=='none'?$('.box-info-search').show('fast'):$('.box-info-search').hide('fast')"><i class="fa fa-search"></i>搜索</button>
                        </div>

                        <!-- /.box-header -->
                        <div class="box-body table-responsive">
                            <table class="table table-hover" id="dataTable">
                                <thead>
                                    <tr>
                                        <th><input type="checkbox" class="minimal icheck_master" /></th>
                                        <th>ID</th>
                                        <th>用户名</th>
                                        <th>手机号</th>
                                        <th>邮箱</th>
                                        <th>更新时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
<%--                                <tbody>--%>
<%--                                <c:forEach items="${tbUsers}" var="tbUser">--%>
<%--                                    <tr>--%>
<%--                                        <td><input id="${tbUser.id}" type="checkbox" class="minimal"></td>--%>
<%--                                        <td>${tbUser.id}</td>--%>
<%--                                        <td>${tbUser.username}</td>--%>
<%--                                        <td>${tbUser.phone}</td>--%>
<%--                                        <td>${tbUser.email}</td>--%>
<%--                                        <td><fmt:formatDate value="${tbUser.updated}" pattern="yyyy-mm-dd HH:mm:ss"></fmt:formatDate></td>--%>
<%--                                        <td>--%>
<%--                                            <a href="/user/form" type="button" class="btn btn-sm  btn-default"><i class="fa fa-search"></i> 查看</a>&nbsp;--%>
<%--                                            <a href="#" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp;--%>
<%--                                            <a href="#" type="button" class="btn btn-sm  btn-danger"><i class="fa fa-trash"></i>删除</a>&nbsp;--%>
<%--                                        </td>--%>
<%--                                    </tr>--%>
<%--                                </c:forEach>--%>
<%--                                </tbody>--%>
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
<%--<sys:modal/>--%>
<script>
    var _dataTable;
    $(function () {
         _dataTable = App.initDataTables("/user/page",[
            {"data":function (row,type,val,meta) {
                    return '<input id="'+row.id+'" type="checkbox" class="minimal">';
                }},
            {"data":"id"},
            {"data":"username"},
            {"data":"phone"},
            {"data":"email"},
            {"data":function (row,type,val,meta){
                    Date.prototype.format = function(fmt){
                        var o = {
                            "M+" : this.getMonth()+1,                 //月份
                            "d+" : this.getDate(),                    //日
                            "h+" : this.getHours(),                   //小时
                            "m+" : this.getMinutes(),                 //分
                            "s+" : this.getSeconds(),                 //秒
                            "q+" : Math.floor((this.getMonth()+3)/3), //季度
                            "S"  : this.getMilliseconds()             //毫秒
                        };

                        if(/(y+)/.test(fmt)){
                            fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length));
                        }

                        for(var k in o){
                            if(new RegExp("("+ k +")").test(fmt)){
                                fmt = fmt.replace(
                                    RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
                            }
                        }
                        return fmt;
                    }
                    return new Date(row.updated).format("yyyy-MM-dd hh:mm:ss");
                }
            },
            {
                "data":function (row,type,val,meta) {
                    var detailUrl="/user/detail?id="+row.id;
                    return '<button class="btn btn-sm  btn-default" onclick="App.showDetail(\''+detailUrl+'\');"><i class="fa fa-search"></i> 查看</button>&nbsp;&nbsp;&nbsp;' +
                        ' <a href="/user/form?id='+row.id+'" type="button" class="btn btn-sm  btn-primary"><i class="fa fa-edit"></i>编辑</a>&nbsp;&nbsp;&nbsp;' +
                        ' <a href="/user/delete?id='+row.id+'" type="button" class="btn btn-sm  btn-danger"><i class="fa fa-trash"></i>删除</a>';
                }
            }
        ])

    })

    function search() {
        var username=$("#username").val();
        var email=$("#email").val();
        var phone=$("#phone").val();
        var param={
            "username":username,
            "email":email,
            "phone":phone
        };
        _dataTable.settings()[0].ajax.data=param;
        _dataTable.ajax.reload();
    }

</script>

</body>
</html>