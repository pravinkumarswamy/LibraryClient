<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!-- Include the above in your HEAD tag -->

<link rel="stylesheet"
	href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<link rel="stylesheet" href="style.css">
<div class="main">


	<div class="container">
		<center>
			<div class="middle">
				<div id="login">

					<form:form action="homepage" method="post" modelAttribute="admin">

						<fieldset class="clearfix">

							<p>
								<span class="fa fa-user"></span><input type="text"
									name="username" Placeholder="Username" required>
								<form:errors cssStyle="color:red;">${message }</form:errors>
							</p>
							<!-- JS because of IE support; better: placeholder="Username" -->
							<p>
								<span class="fa fa-lock"></span><input type="password"
									name="password" Placeholder="Password" required>
								<form:errors cssStyle="color:red;">${message }</form:errors>

							</p>
							<!-- JS because of IE support; better: placeholder="Password" -->

							<div>
								<span
									style="width: 48%; text-align: left; color: white; font-size: 12px; line-height: 18px; display: inline-block;">${message }</span>

								<span
									style="width: 50%; text-align: right; display: inline-block;"><input
									type="submit" value="Sign In"></span>
							</div>

						</fieldset>
						<div class="clearfix"></div>
					</form:form>

					<div class="clearfix"></div>

				</div>
				<!-- end login -->
				<div class="logo">
					LOGIN

					<div class="clearfix"></div>
				</div>

			</div>
		</center>
	</div>

</div>