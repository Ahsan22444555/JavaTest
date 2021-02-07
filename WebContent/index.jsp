<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="styles1.css">
<title>Add Email</title>
</head>
<body> <div class="sidebar">
		 <a href="#"> Add Email</a>
         <a href="emailServlet?name=View">Send Email</a>
   </div>
        
        <div class="content">
        	<div class = "card container" >
	<form action= "emailServlet" class="position" method="post">
          <input type="hidden" name="name" value="addEmail">
          
          <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
    <label for="eamil" class="mdl-textfield__label">Email</label>
      <input type="email" id="email" class="mdl-textfield__input" name="email" required>
      </div>
  <button type="submit" class="mdl-button mdl-js-button mdl-button--fab mdl-button--colored">+</button>
        </form>
      </div>
        </div>
</body>
</html>