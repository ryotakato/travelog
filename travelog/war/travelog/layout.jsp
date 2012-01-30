<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${param.title}</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
</head>

<body>

<div id="outer">
	<div id="header">
		<c:import url="header.jsp"/>
	</div>
	<div id="menu" >
		<c:import url="menu.jsp"/>
	</div>
	<div id="content">
		<c:import url="content.jsp"/>
	</div>
</div>

</body>

</html>