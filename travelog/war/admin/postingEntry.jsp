<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<c:import url="/common/layout.jsp">
  <c:param name="title" value="Tavi's Travelog - Posting Entry"/>
  <c:param name="javascript">
    <script type="text/javascript" lang="javascript">
    <!--
    	function changeForm(target) {
    		target.form.action = "postEntry";
    		target.form.submit;
    	}
    // -->
    </script>
  </c:param>
  <c:param name="content">
	<ul style="color:red;">
		<c:forEach var="error" items="${f:errors()}">
			<li>${f:h(error)}</li>
		</c:forEach>
	</ul>
	<div id="entry-content">
	  <form method="post" action="postedEntry">
	    <h3>${f:h(title) }</h3>
	    <input type="text" ${f:text("title")} style="display: none;"/>
	    <jsp:useBean id="date" class="java.util.Date"/>
	    <h5><fmt:formatDate value="${date}" pattern="yyyy-MM-dd HH:mm:ss" /></h5>
	    <br/>
		<div id="tagsArea">
			<c:forEach var="tag" items="${tagArray}">
				<input type="text" value='${f:h(tag.key)}' name="tagArray" style="width:300px;" maxlength="50" readonly="readonly"/>
				<span style="color:red;">${tag.value ? "new" : ""}</span>
				<br/>
			</c:forEach>
		</div>
	    <br/>
	    <div>${f:br(content)}</div>
	    <textarea name="content" style="display:none;" >${content}</textarea><br/>
	    <input type="submit" value="修正" onclick="changeForm(this)">
	    <input type="submit" value="投稿" ${ fn:length(errors) != 0 ? "disabled='disabled'" : ""} >
	    <br/>
	  </form>
	</div>
  </c:param>
</c:import>
