<%--
  Created by IntelliJ IDEA.
  User: bloom
  Date: 2017/8/13
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" pageEncoding="utf-8" %>
<%--<%@ include file="/WEB-INF/pages/common.jsp"%>--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%
    //全路径的baseurl
    String basep = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
    pageContext.setAttribute("basep", basep);
    String ctx = request.getContextPath();
    pageContext.setAttribute("ctx", ctx);
%>


<!-- general form elements -->
<div class="box box-primary">
    <div class="box-header with-border">
        <h3 class="box-title">添加视频流</h3>
    </div>
    <!-- /.box-header -->
    <!-- form start -->
    <form role="form">
        <div class="box-body">
            <div class="form-group">
                <label for="rtspUrl">流地址</label>
                <input type="text" class="form-control" id="rtspUrl" placeholder="流地址uri">
            </div>
            <div class="form-group">
                <label for="frameHeight">播放帧长</label>
                <input type="text" class="form-control" id="frameHeight" digits="true" placeholder="长（像素）">
                <label for="frameWidth">播放帧宽</label>
                <input type="text" class="form-control" id="frameWidth" digits="true" placeholder="宽（像素）">
            </div>

            <label>探测类型</label>
            <div class="form-group">
                <label><input type="checkbox" id="smokeType" value="smoke"/>探测烟</label>
                <label><input type="checkbox" id="fireType" value="fire"/>探测火</label>
                <label><input type="checkbox" id="personType" value="person"/>探测人</label>
            </div>

        </div>
        <!-- /.box-body -->

        <div class="box-footer">
            <button class="btn btn-primary" id="confirm" onclick="doConfirm();">确认</button>
            <button class="btn btn-primary" id="cancel" onclick="doCancel();">取消</button>
        </div>
    </form>
</div>
<script>

    function doConfirm() {
        var detectList = new Array();
        if ($("#smokeType").prop("checked"))
            detectList.push("smoke");
        if ($("#fireType").prop("checked"))
            detectList.push("fire");
        if ($("personType").prop("checked"))
            detectList.push("person");
        console.log(detectList);
        <%--$.get("${ctx}/main/add-stream", {--%>
            <%--rtspUrl: $("#rtspUrl").val(), frameHeight: $("#frameHeight").val(),--%>
            <%--frameWidth: $("#frameWidth").val(), typeList: detectList--%>
        <%--}, function (data) {--%>

        <%--});--%>

        $.ajax({
            url: "${ctx}/main/add-stream",
            async:false,
            traditional:true,
            data:{rtspUrl: $("#rtspUrl").val(), frameHeight: $("#frameHeight").val(),
                frameWidth: $("#frameWidth").val(), typeList:detectList}, //最主要的，设置参数，
            success:function(data){

            }
        });

        $.get("${ctx}/main/get-stream-list", {}, function (data) {
            alert("comfirmed");
            $("#content").html(data);
        });
    }

    function doCancel(){
        alert("comfirmed");
        $.get("${ctx}/main/get-stream-list", {}, function (data) {
            alert("comfirmed");
            $("#content").html(data);

        });
    }



</script>
<!-- /.box -->