<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>





<link rel="stylesheet" href="style2.css">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Varela+Round&display=swap" rel="stylesheet">
</head>
<body>

	<form:form action="after-update" method="post" modelAttribute="library">
		<div id="editModal" class="modal-fade">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h4 class="modal-title">Edit Employee</h4>
						<!-- <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
					</div>


					<div class="modal-body">
						<div class="form-group">
							<label>Student ID</label>
							<form:input path="student_id" type="number" class="form-control"
								name="student_id"></form:input>
						</div>
						<div class="form-group">
							<label>Name Of the Student</label>
							<form:input path="name_of_the_student" type="text"
								class="form-control" name="name_of_the_student"></form:input>
						</div>
						<div class="form-group">
							<label>Book Issued</label>
							<form:input path="book_issued" type="text" class="form-control"
								name="book_issued"></form:input>
						</div>
						<div class="form-group">
							<label>Email Id</label>
							<form:input path="email_id" class="form-control" name="email_id"></form:input>
						</div>
						<div class="form-group">
							<label>Phone Number</label>
							<form:input path="phone_number" type="number"
								class="form-control" name="phone_number"></form:input>
						</div><br>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn" data-dismiss="modal"
							value="Cancel"> <input type="submit" class="btn"
							value="Save">
					</div>

				</div>
			</div>
		</div>
	</form:form>

</body>
</html>