<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<div id="author">
	<h2>Author</h2>
<p>aaaaaaaaa</p>
</div>
<hr/>
<div id="recent">
	<h2>Recent Entry</h2>
	<ul>
	<c:forEach var="e" items="${recentEntries}">
		<li><a href="${f:url('viewEntry?id=')}${f:h(e.key.name) }">${f:h(e.title) }</a></li>
	</c:forEach>
	<li style="text-align: right;"><a href="#">More...</a>
	</ul>
</div>
<hr/>
<div id="category">
	<h2>Category</h2>
	<ul>
	<c:forEach var="t" items="${rootCategories}">
		<li><a href="${f:url('viewCategory?name=')}${f:h(t.name) }">${f:h(t.name) }</a></li>
	</c:forEach>
	</ul>
</div>

<hr/>
