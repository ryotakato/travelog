<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<div id="entry-content">
  <h3>${f:h(entry.title) }</h3>
  <h5><fmt:formatDate value="${entry.postedDate}" pattern="yyyy-MM-dd HH:mm:ss" /></h5>
  <br/>
  <div>${f:br(body.content)}</div>
  <br/>
</div>
<hr/>
<div id="entry-comments">
  <h4>Comments (${fn:length(comments)})</h4><br/>
  <c:forEach var="comment" items="${comments}">
    ${f:br(f:h(comment.content)) }<br/>
      <p class="about-comment">
        by ${f:h(comment.postedName) } 
        (<fmt:formatDate value="${comment.postedDate}" pattern="yyyy-MM-dd HH:mm:ss" />)
      </p>
    <br/>
    <br/>
    <br/>
  </c:forEach>
</div>
<hr/>
<div id="entry-post-comment">
  <h4>Post Comment</h4>
  <form id="comment-form" method="post" action="comment">
    <p>Name:</p>
    <input type="text" name="postedName" /><br/>
    <p>Comment:</p>
    <textarea name="content"></textarea><br/>
    <input type="hidden" name="entryId" value="${f:h(entry.key.name)}">
    <input type="hidden" name="protect" value="a">
    <br/>
    <button id="comment-button" style="width:70px;">Post</button>
  </form>
</div>
