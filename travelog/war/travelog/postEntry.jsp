<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>travelog PostEntry</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
</head>
<body>
<h1>Tavi's Travelog</h1>
<hr/>
<form method="post" action="postingEntry">
タイトル<br/>
<input type="text" ${f:text("title")}  style="width:300px;" maxlength="500"><br/>
投稿内容<br/>
<textarea name="content" style="width:900px; height:600px;">${f:h(content)}</textarea><br/>
<input type="submit" value="記事を投稿する">
</form>

</body>
</html>
