<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<div id="author">
	<h2>Author</h2>
	<a href="aboutMe"><img id="aboutMe" src="/img/aboutme_s.jpg" alt="" title="" width="120" height="80" ></a>
	<p><a href="/aboutMe">tavi</a></p>
</div>
<hr/>
<div id="recent">
	<h2>Recent Entry</h2>
	<ul>
	<c:forEach var="e" items="${recentEntries}">
		<li><a href="${f:url('viewEntry?id=')}${f:h(e.key.name) }">${f:h(e.title) }</a></li>
	</c:forEach>
	<li style="text-align: right;">
		<a href="${f:url('/viewArchive?year=')}${f:h(recentYear)}">More...</a>
	</li>
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

<div id="powered">
	<img src="http://code.google.com/appengine/images/appengine-silver-120x30.gif" alt="Powered by Google App Engine" />
</div>
<hr/>
