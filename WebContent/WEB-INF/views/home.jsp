<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Listing Events using Services</title>
</head>
<body>
	<h1>Listing events using Service</h1>
	
	
	
	<c:forEach var="row" items="${eventsList}">
		Ziua: ${weekday}<br/>
		Date: ${row.timetable.date}<br/>
		Events ID: ${row.id}<br/>
		Events name: ${row.name}<br/>
		Places Id: ${row.places.id}<br/>
		Places Name: ${row.places.name}<br/>
		Town Name: ${row.towns.name}<br/>
		District Name: ${row.districts.name}<br/>
		Categories id: ${row.categories.id}<br/>
		Categories Name: ${row.categories.name}<br/>
		Broadcasters Name: ${row.broadcasters.name}<br/>
		Time Name: ${row.timetable.time}<br/>
		Time fullday: ${row.timetable.fullday}<br/>
		 <br/>
	</c:forEach>
	
</body>
</html>