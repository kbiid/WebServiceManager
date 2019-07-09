<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Login Page</title>

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>
<!-- Custom styles for this template -->
<link
	href="https://getbootstrap.com/docs/4.3/examples/sign-in/signin.css"
	rel="stylesheet">
</head>
<body class="text-center">
	<form class="form-signin" method="post" action="${path}/kkj/login">
		<div
			style="position: absolute; top: 23px; left: 730px; width: 300px; height: 54px;">
			<h1 class="h3 mb-3 font-weight-normal"
				style="font-weight: bold; font-size: 100px; text-align: center; color: rgb(41, 128, 185);">Welcome!!</h1>
		</div>

		<div style="font-size: 25px; text-align: center;">아이디</div>
		<div>
			<input type="text" name="id" class="form-control" required
				autofocus>
		</div>
		<br>
		<div style="font-size: 25px; text-align: center;">비밀번호</div>
		<div>
			<input type="password" name="passwd" class="form-control"
				required>
		</div>
		<br>
		<button class="btn btn-lg btn-primary btn-block" type="submit" id="loginButton">로그인</button>
	</form>
</body>
</html>
