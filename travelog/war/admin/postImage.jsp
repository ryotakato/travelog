<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Tavi's Travelog - Post Image</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
</head>
<body>

<h1>Tavi's Travelog</h1>
<hr/>
<form method="post" action="postedImage" enctype="multipart/form-data">
<p>Image Upload (Limit : 1 MBytes)</p>
<input id="fileImage" type="file" name="fileImage" />
<input type="submit" value="Upload">
</form>

</body>
</html>
