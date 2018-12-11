<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Ninja Gold</title>
    <link rel="stylesheet" href="{% static 'ninjaGoldAppCSS/bootstrap.css' %}" media="screen" title="no title"  charset="utf-8">
    <link rel="stylesheet" href="{% static 'ninjaGoldAppCSS/style.css' %}" media="screen" title="no title"  charset="utf-8">
</head>
    <body>
        <fieldset>
            <legend>Ninja Gold Count <c:out value="${gold}"/></legend>
             <div class = "boxes" >
                  <form action="/process" method="POST">
                      <h2>Farm</h2>
                      <hr>
                      <p>Earns 10-20 gold</p>
                      <input type="hidden" name="building" value="farm" />
                    <input class = "btn btn-primary" type="submit" value="Find Gold!"/>
                   </form>
             </div>
             <div class = "boxes" >
                  <form action="/process" method="POST">
                      <h2>Cave</h2>
                      <hr>
                      <p>Earns 5-10 gold</p>
                      <input type="hidden" name="building" value="cave" />
                    <input class = "btn btn-primary" type="submit" value="Find Gold!"/>
                   </form>
             </div>
             <div class = "boxes" >
                  <form action="/process" method="POST">
                      <h2>House</h2>
                      <hr>
                      <p>Earns 2-5 gold</p>
                      <input type="hidden" name="building" value="house" />
                    <input class = "btn btn-primary" type="submit" value="Find Gold!"/>
                </form>
             </div>
             <div class = "boxes" >
                  <form action="/process" method="POST">
                      <h2>Casino</h2>
                      <hr>
                      <p>Earn/Takes 0-50 gold</p>
                      <input type="hidden" name="building" value="casino" />
                    <input class = "btn btn-primary" type="submit" value="Find Gold!"/>
                   </form>
             </div>
             <div id = "activity">
             <c:forEach items="${events}" var="event">
                <p>${event}</p>
            	</c:forEach>
            </div>
            <div>
                <form action = "/clear" method = 'POST'>
                    <input class = "btn btn-primary" type="submit" name="clear" value="Clear Gold History">
                </form>
            </div>
        </fieldset>
    </body>
</html>