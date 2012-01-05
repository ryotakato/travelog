<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>travelog PostingEntry</title>
<link rel="stylesheet" type="style/css" href="/css/global.css" />
<script type="text/javascript">
<!--

function changeForm(target) {
	target.form.action = "postEntry";
	target.form.submit;
}

// -->
</script>
</head>
<body>
<h1>Tavi's Travelog</h1>
<hr/>
<form method="post" action="postedEntry">
タイトル<br/>
<input type="text" ${f:text("title")} style="width:300px;" maxlength="500" readonly="readonly" /><br/>
投稿内容<br/>
<textarea name="content" style="width:900px; height:600px;" readonly="readonly" >${f:br(content)}</textarea><br/>
<input type="submit" value="戻って修正" onclick="changeForm(this)"><input type="submit" value="これで投稿" >
</form>
</body>
</html>