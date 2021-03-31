<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Library Records</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="style1.css">
<script>
$(document).ready(function(){
	// Activate tooltip
	$('[data-toggle="tooltip"]').tooltip();
	
	// Select/Deselect checkboxes
	var checkbox = $('table tbody input[type="checkbox"]');
	$("#selectAll").click(function(){
		if(this.checked){
			checkbox.each(function(){
				this.checked = true;                        
			});
		} else{
			checkbox.each(function(){
				this.checked = false;                        
			});
		} 
	});
	checkbox.click(function(){
		if(!this.checked){
			$("#selectAll").prop("checked", false);
		}
	});
});
</script>
</head>
<body>
    <div class="container">
		<div class="table-responsive">
			<div class="table-wrapper">
				<div class="table-title">
					<div class="row">
						<div class="col-xs-6">
							<h2>Manage <b>Library Records</b></h2>
						</div>
						<div class="col-xs-6">
							<a href="#addModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add New Record</span></a>
							<a href="#deleteModal" class="btn btn-danger" data-toggle="modal"><i class="material-icons">&#xE15C;</i> <span>Delete</span></a>						
						</div>
					</div>
				</div>
				
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Student ID</th>
							<th>Name of the Student</th>
							<th>Book Issued</th>
							<th>Email Id</th>
							<th>Phone Number</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${library}" var="lib">
						<tr>
							<td>${lib.student_id }</td>
							<td>${lib.name_of_the_student}</td>
							<td>${lib.book_issued }</td>
							<td>${lib.email_id }</td>
							<td>${lib.phone_number }</td>
							<td>
								<a href="update-record?student_id=${lib.student_id}&name_of_the_student=${lib.name_of_the_student}&book_issued=${lib.book_issued}&email_id=${lib.email_id}&phone_number=${lib.phone_number}"
							class="edit" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i></a>
								<a href="delete-record?student_id=${lib.student_id}" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</td>
						</tr>
						
						
											
						</c:forEach>
					</tbody>
				</table>
				
			</div>
		</div>        
    </div>
	<!-- Edit Modal HTML -->
	<div id="addModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="insert_operation" method="post">
					<div class="modal-header">						
						<h4 class="modal-title">Add New Record</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Student ID</label>
							<input type="number" class="form-control" name="student_id">
						</div>					
						<div class="form-group">
							<label>Name Of The Student</label>
							<input type="text" class="form-control" name="name_of_the_student">
						</div>
						<div class="form-group">
							<label>Book Issued</label>
							<input type="text" class="form-control" name="book_issued">
						</div>
						<div class="form-group">
							<label>Email Id</label>
							<textarea class="form-control" name="email_id"></textarea>
						</div>
						<div class="form-group">
							<label>Phone Number</label>
							<input type="number" class="form-control" name="phone_number">
						</div>					
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-success" value="Add">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Edit Modal HTML -->
	<div id="editModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form:form action="update_operation" method="post" modelAttribute="">
					<div class="modal-header">						
						<h4 class="modal-title">Edit Record</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<label>Student ID</label>
							<input type="number" class="form-control" name="student_id">
						</div>					
						<div class="form-group">
							<label>Name Of the Student</label>
							<input type="text" class="form-control" name="name_of_the_student">
						</div>
						<div class="form-group">
							<label>Book Issued</label>
							<input type="text" class="form-control" name="book_issued">
						</div>
						<div class="form-group">
							<label>Email Id</label>
							<textarea class="form-control" name="email_id"></textarea>
						</div>
						<div class="form-group">
							<label>Phone Number</label>
							<input type="number" class="form-control" name="phone_number">
						</div>					
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-info" value="Save">
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form>
					<div class="modal-header">						
						<h4 class="modal-title">Delete Record</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Are you sure you want to delete these Records?</p>
						<p class="text-warning"><small>This action cannot be undone.</small></p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-danger" value="Delete">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>