<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

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

<ul style="color:red;">
	<c:forEach var="error" items="${f:errors()}">
		<li>${f:h(error)}</li>
	</c:forEach>
</ul>

<form method="post" action="postedEntry">
タイトル<br/>
<input type="text" ${f:text("title")} style="width:300px;" maxlength="500" readonly="readonly" /><br/>
タグ<br/>
<div id="tagsArea">
	<c:forEach var="tag" items="${tagArray}">
		<input type="text" value='${f:h(tag.key)}' name="tagArray" style="width:300px;" maxlength="50" readonly="readonly"/>
		<span style="color:red;">${tag.value ? "new" : ""}</span>
		<br/>
	</c:forEach>
</div>
<br/>
投稿内容<br/>
<textarea name="content" style="width:900px; height:600px;" readonly="readonly" >${f:br(content)}</textarea><br/>
<input type="submit" value="修正" onclick="changeForm(this)">
<input type="submit" value="投稿" ${ fn:length(errors) != 0 ? "disabled='disabled'" : ""} >
</form>
</body>
</html>