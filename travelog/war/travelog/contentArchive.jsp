<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<div>
  <h3>${f:h(year) }</h3>
</div>
<div>
	<h4>Entry</h4>
	<c:forEach var="entry" items="${entries}">
		<div><a href="${f:url('viewEntry?id=')}${f:h(entry.key.name) }">
			<fmt:formatDate value="${entry.postedDate}" pattern="yyyy/MM/dd" /> : 
			${f:h(entry.title) }
		</a></div>
	</c:forEach>
</div>