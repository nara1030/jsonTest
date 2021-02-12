<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!
</h1>
<P>  The time on the server is ${serverTime}. </P>
<button onclick="sendJsonByPost()">send</button>
<script>
	function sendJsonByPost () {
		var xmlhttp = new XMLHttpRequest();
		var url = "http://localhost:8080/emp/add2";
		xmlhttp.open("POST", url, true);
		xmlhttp.setRequestHeader("Content-Type", "application/json");
		xmlhttp.onreadystatechange = function () {
			if (xmlhttp.readyState === 4 && xmlhttp.status === 200) {
				var json = JSON.parse(xmlhttp.responseText);
				console.log(json);
			}
		}
		var data = JSON.stringify({"deptCd" : "02", "empCd" : "02", "empNm" : "cylee"});
		// var data = '{"deptCd" : "02", "empCd" : "02", "empNm" : "cylee"}';
		xmlhttp.send(data);
	}
</script>
</body>
</html>
