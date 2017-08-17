<%--
  Created by IntelliJ IDEA.
  User: bloom
  Date: 2017/8/13
  Time: 10:35
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
<html>
<head>
    <title>Title</title>
</head>
<body>
 error !!!
</body>
</html>
