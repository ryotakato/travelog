<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>${param.title}</title>
<link rel="stylesheet" type="text/css" href="/css/global.css" />
<script type="text/javascript" lang="javascript" src="/js/jquery-1.6.4.js" ></script>
<script type="text/javascript" lang="javascript">
<!--

// -->
</script>
${param.javascript}
</head>

<body>

<div id="outer">
	<div id="inner">
		<div id="header">
			<c:import url="/common/header.jsp"/>
		</div>
		<div id="menu">
			<c:import url="/common/menu.jsp"/>
		</div>
		<div id="content">
			${param.content}
		</div>
	</div>
</div>

</body>

</html>