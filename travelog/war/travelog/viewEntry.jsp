<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>travelog ViewEntry</title>
</head>
<body>
<h1>Tavi's Travelog</h1>
<hr/>
<div>
  <div>
    <h3>${f:h(entry.title) }</h3>
    <h5><fmt:formatDate value="${entry.postedDate}" pattern="yyyy-MM-dd HH:mm:ss" /></h5>
    <div>${f:br(body.content)}</div>
  </div>
  <hr/>
  <div>
    <h4>Comments</h4><br/>
    <c:forEach var="comment" items="${commentList}">
      ${f:br(f:h(comment.content)) }<br/>
      By ${f:h(comment.postedName) }
      <br/>
      <br/>
      <br/>
      <br/>
    </c:forEach>
  </div>
  <hr/>
  <div>
    <h4>Post Comment</h4>
    <form method="post" action="comment">
      <p>Name:</p>
      <input type="text" name="postedName" /><br/>
      <p>Comment:</p>
      <textarea name="content"></textarea><br/>
      <input type="hidden" name="entryId" value="${f:h(entry.key.name)}">
      <input type="submit" value="コメント投稿">
    </form>

  </div>
</div>
</body>
</html>
