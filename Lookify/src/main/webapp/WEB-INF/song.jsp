<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<h1>All Songs</h1>
<form:form action="/search" method="post">
	<input type="text" name="artist">
	<input type="submit" value="Search for an Artist"/>
</form:form>
<table>
    <thead>
        <tr>
            <th>Title</th>
            <th>Artist</th>
            <th>Rating</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${songs}" var="song">
        <tr>
            <td><c:out value="${song.title}"/></td>
            <td><c:out value="${song.artist}"/></td>
            <td><c:out value="${song.rating}"/></td>
            
            <td> 
            <form:form action="/songs/${song.id}" method="post">
    		<input type="hidden" name="_method" value="delete">
            <input type="submit" value="Delete"/>
            </form:form>
            </td>
        </tr>
        </c:forEach>
    </tbody>
</table>

<form:form action="/songs/${song.id}" method="post">
   <input type="hidden" name="_method" value="delete">
   <input type="submit" value="Delete"/>
</form:form>
</body>
</html>