<%--
  Created by IntelliJ IDEA.
  User: bloom
  Date: 2017/8/13
  Time: 9:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%--<%@ include file="/WEB-INF/pages/common.jsp"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%
    //全路径的baseurl
    String basep = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
    pageContext.setAttribute("basep", basep);
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        服务管理
        <small>服务列表</small>
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
        <li class="active">Here</li>
    </ol>
</section>

<!-- Main content -->
<section class="content">

    <!-- Your Page Content Here -->
    <!-- /.row -->
    <div class="row">
        <div class="col-xs-12">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">视频状态列表</h3>

                    <div class="box-tools">
                        <div class="input-group input-group-sm pull-right" style="width: 250px;">

                            <input type="text" name="table_search" class="form-control pull-right"
                                   placeholder="Search">

                            <div class="input-group-btn">
                                <button type="submit" class="btn btn-default btn-sm"><i
                                        class="fa fa-search"></i></button>
                            </div>
                        </div>

                        <button type="button" class="btn btn-info" id="add-stream">刷新</button>
                    </div>

                </div>
                <!-- /.box-header -->
                <div class="box-body table-responsive no-padding">
                    <table class="table table-hover">
                        <tr>
                            <th>选中</th>
                            <th>节点ID</th>
                            <th>开始时间</th>
                            <th>状态</th>
                            <th>视频数量</th>
                            <th>RTSP Address</th>
                        </tr>
                        <tr>
                            <td>
                                <div class="checkbox icheck">
                                    <label>
                                        <input type="checkbox">
                                    </label>
                                </div>
                            </td>
                            <td>183</td>
                            <td>John Doe</td>
                            <td>11-7-2014</td>
                            <td><span class="label label-success">Approved</span></td>
                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                        </tr>
                        <tr>
                            <td>
                                <div class="checkbox icheck">
                                    <label>
                                        <input type="checkbox">
                                    </label>
                                </div>
                            </td>
                            <td>219</td>
                            <td>Alexander Pierce</td>
                            <td>11-7-2014</td>
                            <td><span class="label label-warning">Pending</span></td>
                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                        </tr>
                        <tr>
                            <td>
                                <div class="checkbox icheck">
                                    <label>
                                        <input type="checkbox">
                                    </label>
                                </div>
                            </td>
                            <td>657</td>
                            <td>Bob Doe</td>
                            <td>11-7-2014</td>
                            <td><span class="label label-primary">Approved</span></td>
                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                        </tr>
                        <tr>
                            <td>
                                <div class="checkbox icheck">
                                    <label>
                                        <input type="checkbox">
                                    </label>
                                </div>
                            </td>
                            <td>175</td>
                            <td>Mike Doe</td>
                            <td>11-7-2014</td>
                            <td><span class="label label-danger">Denied</span></td>
                            <td>Bacon ipsum dolor sit amet salami venison chicken flank fatback doner.</td>
                        </tr>
                    </table>
                </div>
                <!-- /.box-body -->
            </div>
            <!-- /.box -->
        </div>
    </div>
</section>

<script>

</script>
<!-- /.content -->