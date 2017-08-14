<%--
  Created by IntelliJ IDEA.
  User: bloom
  Date: 2017/8/13
  Time: 9:29
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


<!-- general form elements -->
<div class="box box-primary">
    <div class="box-header with-border">
        <h3 class="box-title">Quick Example</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form role="form">
        <div class="box-body">
            <div class="form-group">
                <label for="exampleInputEmail1">Email address</label>
                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Enter email">
            </div>
            <div class="form-group">
                <label for="exampleInputPassword1">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
            </div>
            <div class="form-group">
                <label for="exampleInputFile">File input</label>
                <input type="file" id="exampleInputFile">

                <p class="help-block">Example block-level help text here.</p>
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox"> Check me out
                </label>
            </div>
        </div>
        <!-- /.box-body -->

        <div class="box-footer">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</div>
<!-- /.box -->