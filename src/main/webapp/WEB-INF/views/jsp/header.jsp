<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Lets Pool</title>
<link href="../resources/css/jquery.datetimepicker.css" type="text/css" rel="stylesheet">
<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.0/jquery.min.js"></script>
<script src="../resources/js/jquery.datetimepicker.full.js"></script>
<script src="../resources/js/common.js"></script>
</head>
<body>

	<div id="fb_login_button">
		<fb:login-button scope="public_profile,email" onlogin="checkLoginState();"></fb:login-button>
	</div>

	<div id="status"></div>

</body>
</html>