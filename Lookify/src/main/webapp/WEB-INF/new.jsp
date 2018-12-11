<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<meta charset="ISO-8859-1">
<title>Lookify, Beeyatch</title>
</head>
<body>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<h1>New Song</h1>
<form:form action="/songs/new" method="post" >
    <label>Title<br>
	<input type="text" name="title">
	</label><br>
	
	<label>
	Artist:<br>
	<input type="text" name="artist">
	</label><br>
	
	<label>
	Rating:<br>
	<select name="rating">
       <option value="0">--SELECT--</option>
       <option value="1">1</option>
       <option value="2">2</option>
       <option value="3">3</option>
       <option value="4">4</option>
       <option value="5">5</option>
       <option value="6">6</option>
       <option value="7">7</option>
       <option value="8">8</option>
       <option value="9">9</option>
       <option value="10">10</option>
       </select>
	</label><br>
    <input type="submit" value="Submit a Song!"/>
</form:form> 
<a href="/dashboard">Go back...</a>   
</body>
</html>