<%@ page import="org.glob.Scripting" %>
<%--
  Created by IntelliJ IDEA.
  User: rimar
  Date: Sep 16, 2008
  Time: 1:18:15 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String code = request.getParameter("code");
    String result = null;
    if (code != null && code.trim().length() != 0) {
        result = new Scripting().runGroovy(code);
    }
%>
<html>
  <head><title>groovy</title></head>
  <body>
  <%
      if (result != null) {
  %>
  <h2>Script result:</h2>
  <pre><%=result%></pre>
  <%
      }
  %>
  <h2>Groovy code goes here</h2>
  <form action="groovy.jsp" method="post">
      <textarea rows="30" cols="50" id="code" name="code"><%=code==null?"":code%></textarea>
      <br/>
      <input type="submit" value="run"/>
  </form>
  </body>
</html>