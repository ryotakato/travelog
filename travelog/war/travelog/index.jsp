<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>travelog Index</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
</head>
<body>
<h1>Tavi's Travelog</h1>

<c:forEach var="e" items="${entryList}">
<a href="${f:url('viewEntry?id=')}${f:h(e.key.name) }">${f:h(e.title) }　：　${f:h(e.key.name) }</a>
<hr/>
</c:forEach>

</body>
</html>
