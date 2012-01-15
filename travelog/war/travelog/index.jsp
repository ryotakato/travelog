<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
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

<hr/><hr/><hr/><hr/>

<c:forEach var="t" items="${tagList}">
${f:h(t.name) }
<hr/>
</c:forEach>

</body>
</html>
