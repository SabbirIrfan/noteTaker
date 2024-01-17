<%@ page import="com.example.notetaker.helper.FactoryProvider" %>
<%@ page import="org.hibernate.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.notetaker.entity.Note" %>
<%@ page import="org.hibernate.query.Query" %>

<%--
  Created by IntelliJ IDEA.
  User: john_doe
  Date: ১৭/১/২৪
  Time: ২:১২ PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>allNotes</title>
    <%@include file="allLink.jsp"%>

</head>
<body>

<div class="container">
    <%@include file="navbar.jsp"%>

<%--    <% out.println(request.getAttribute("status")); %>--%>

    <%
        Session s  = FactoryProvider.getFactory().openSession();

        Query q = s.createQuery("from Note");
        List<Note> list = q.list();

        for(Note note: list){
            if(note.getTittle() == null) continue;
%>
    <div class="card flexCard" style="width: 69.7rem;">
        <div class="card-body ">
            <h5 class="card-title "><%= note.getTittle() %></h5>
            <p class="card-text"><%= note.getContent() %></p>
            <div class="container text-center">
            <a href="deletenoteservlet?id=<%= note.getId()%>" class="btn btn-primary">Delete</a>
            <a href="editservlet?id=<%=note.getId()%>" class="btn btn-primary">Edit</a>
            </div>
        </div>
    </div>

    <%

        }
        s.close();

    %>

    <%--   ADD NOTES  --%>


</div>

</body>
</html>
