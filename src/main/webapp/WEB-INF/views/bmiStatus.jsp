<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BMI Status</title>
</head>
<body>
    <h2 id="status">
    <% if (request.getAttribute("check") != null) { %>
    	${dob}
    <% } 
    	if(request.getAttribute("check") == null)    
    {%>
        Id:${validUser.userId}<br>
        Name: ${validUser.name}<br>
        Height: ${validUser.height}<br>
        Weight: ${validUser.weight}<br>
        BMI: ${bmi}<br>
        Status: You are ${BMIstatus}<br>
        ${dob}
        <%} %>
    </h2>

</body>
</html>
