<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<div>
	<h4>Category</h4>
	<c:forEach var="category" items="${categories}">
		<div><a href="${f:url('viewCategory?name=')}${f:h(category.name) }">${f:h(category.name) }</a></div>
	</c:forEach>
</div>
<hr/>
<div>
	<h4>Entry</h4>
	<c:forEach var="entry" items="${entries}">
		<div><a href="${f:url('viewEntry?id=')}${f:h(entry.key.name) }">${f:h(entry.title) }</a></div>
	</c:forEach>
</div>