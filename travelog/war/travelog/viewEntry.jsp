<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<c:import url="layout.jsp">
  <c:param name="title" value="Tavi's Travelog - ${f:h(entry.title) }"/>
  <c:param name="contentJsp">
  	<c:import url="entry.jsp"/>
  </c:param>
</c:import>
