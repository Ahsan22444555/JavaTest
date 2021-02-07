<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="C" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" href="styles1.css">
<title>Edit Content</title>
</head>
<body>
  <div class="sidebar">
		 <a href="index.jsp"> Add Email </a>
         <a href="#">Send Email</a>
   </div>
   
   <div class="content">
		<table class="table">
		<thead>
        <tr>
      		 <th scope="col">Email</th>
      		 <th scope="col">Name</th>
      		 <th scope="col">Fee</th>
      		 <th></th>
      		 </tr>
      		 </thead>
      		 <tbody id="emailList">
      		 <C:forEach var="email" items="${person}">
      		 <tr>
      		 <td>${email.email}</td>
      		 <td>${email.name}</td>
      		 <td>${email.fee}</td>
      		 <td class="delete"><a href="emailServlet?name=delete&&email=${email.email}"><button>Delete</button> </a></td>
      		 </tr>       		 
      		</C:forEach>
      		</tbody>
      	</table>
      	<a href="sendEmail?name=send">Send Email</a> 
         <button id="Hello" type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter" onclick=>
  Edit
</button>

<!-- Modal -->
<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
  <div class="modal-dialog modal-dialog-centered" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLongTitle">Edit Name and Fee</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form action="emailServlet" method="post">
        <input type="hidden" name="name" value="addname">
        <label for="email">Email:</label>
  <input type="email" id="email" name="email"><br><br>
  <label for="name">Name:</label>
  <input type="text" id="name" name="ename" placeholder="Name"><br><br>
  <label for="fee">Fee:</label>
  <input type="text" id="fee" name="fee" placeholder="0.0"><br><br>
  <button>Submit</button>
</form>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
<C:forEach var="result" items="${message}">
        <div class="alert alert-success" role="alert">
  <h4 class="alert-heading">${result}</h4>
</div>        
     
          
     
        </C:forEach>
        </div>
        
        <script src="apps.js"></script>
</body>
</html>