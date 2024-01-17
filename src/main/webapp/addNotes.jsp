<%@ page import="static org.apache.taglibs.standard.tag.common.core.OutSupport.out" %><%--
  Created by IntelliJ IDEA.
  User: john_doe
  Date: ১৬/১/২৪
  Time: ৩:৪৩ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add notes</title>
    <%@include file="allLink.jsp"%>
</head>
<body>
<div class="container">
    <%@include file="navbar.jsp"%>
    <%
    if(request.getAttribute("status") != null)
        out.println(request.getAttribute("status"));


    %>


<%--   ADD NOTES  --%>
    <%@include file="form.jsp"%>

</div>
</body>
</html>
