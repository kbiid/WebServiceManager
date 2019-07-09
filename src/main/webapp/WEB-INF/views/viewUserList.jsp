<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>UserList</title>

<!-- Bootstrap core CSS -->
<link
	href="https://getbootstrap.com/docs/4.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

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
</head>
<body>
	<nav
		class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
		<div class="navbar-brand col-sm-3 col-md-2 mr-0">Welcome!!</div>
		<ul class="navbar-nav px-3">
			<li class="nav-item text-nowrap"><a class="nav-link" href="/kkj">로그아웃</a></li>
		</ul>
	</nav>

	<div class="container-fluid">
		<div
			style="position: absolute; top: 100px; left: 600px; width: 800px; height: 300px;">
			<h2 style="text-align: center;">유저 리스트</h2>
			<div class="table-responsive">
				<table class="table table-striped table-sm">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>성</th>
							<th>Email</th>
							<th>성별</th>
							<th>Ip 주소</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>1,001</td>
							<td>Lorem</td>
							<td>ipsum</td>
							<td>dolor</td>
							<td>sit</td>
							<td>sit</td>
						</tr>
						<tr>
							<td>1,002</td>
							<td>amet</td>
							<td>consectetur</td>
							<td>adipiscing</td>
							<td>elit</td>
							<td>elit</td>
						</tr>
						<tr>
							<td>1,003</td>
							<td>Integer</td>
							<td>nec</td>
							<td>odio</td>
							<td>Praesent</td>
							<td>Praesent</td>
						</tr>
						<tr>
							<td>1,003</td>
							<td>libero</td>
							<td>Sed</td>
							<td>cursus</td>
							<td>ante</td>
							<td>ante</td>
						</tr>
						<tr>
							<td>1,004</td>
							<td>dapibus</td>
							<td>diam</td>
							<td>Sed</td>
							<td>nisi</td>
							<td>nisi</td>
						</tr>
						<tr>
							<td>1,005</td>
							<td>Nulla</td>
							<td>quis</td>
							<td>sem</td>
							<td>at</td>
							<td>at</td>
						</tr>
						<tr>
							<td>1,006</td>
							<td>nibh</td>
							<td>elementum</td>
							<td>imperdiet</td>
							<td>Duis</td>
							<td>Duis</td>
						</tr>
						<tr>
							<td>1,007</td>
							<td>sagittis</td>
							<td>ipsum</td>
							<td>Praesent</td>
							<td>mauris</td>
							<td>mauris</td>
						</tr>
						<tr>
							<td>1,008</td>
							<td>Fusce</td>
							<td>nec</td>
							<td>tellus</td>
							<td>sed</td>
							<td>sed</td>
						</tr>
						<tr>
							<td>1,009</td>
							<td>augue</td>
							<td>semper</td>
							<td>porta</td>
							<td>Mauris</td>
							<td>Mauris</td>
						</tr>
						<tr>
							<td>1,010</td>
							<td>massa</td>
							<td>Vestibulum</td>
							<td>lacinia</td>
							<td>arcu</td>
							<td>arcu</td>
						</tr>
					</tbody>
				</table>
			</div>
			<nav style="width: 800px; left: 50px; height: 40px; padding: 0px;">
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous"> <span aria-hidden="true">«</span> <span
							class="sr-only">Previous</span>
					</a></li>
					<li class="page-item active"><a class="page-link" href="#">1</a></li>
					<li class="page-item"><a class="page-link" href="#">2</a></li>
					<li class="page-item"><a class="page-link" href="#">3</a></li>
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Next"> <span aria-hidden="true">»</span> <span
							class="sr-only">Next</span>
					</a></li>
				</ul>
			</nav>
			<div align="right">
				<button class="btn btn-lg btn-primary btn-block" type="submit"
					id="addUser"
					style="left: 700px; width: 100px; height: 40px; text-align: center; font-size: 20px;">추가</button>
			</div>
		</div>
	</div>
</body>
</html>
