<%@ page import="org.hibernate.Session" %>
<%@ page import="org.hibernate.Transaction" %>
<%@ page import="org.glob.da.pojo.Post" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.List" %>
<%@ page import="org.glob.util.SpringFactory" %>
<%@ page import="org.glob.da.PostDAO" %>
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html
PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
    <title>glob app</title>
</head>
<body>
<%
    PostDAO postDAO = SpringFactory.getBean("postDAO", PostDAO.class);
    Post p = new Post();
    p.setDate(new Date());
    p.setText("hello");
    postDAO.savePost(p);

%>
<h2>Added one line</h2>

<h2>All Records</h2>
<table>
    <tr>
        <td>ID</td>
        <td>Date</td>
        <td>Post</td>
    </tr>
    <%
        List<Post> posts = postDAO.listPosts();
        for (Post post : posts) {
    %>

    <tr>
        <td><%=post.getId()%> </td>
        <td><%=post.getDate()%> </td>
        <td><%=post.getText()%> </td>
    </tr>
    <%
        }
    %>
</table>

</body>
</html>