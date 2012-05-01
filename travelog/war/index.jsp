<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<c:import url="layout.jsp">
  <c:param name="title" value="Tavi's Travelog"/>
  <c:param name="content">
  	<c:import url="entry.jsp"/>
  </c:param>
</c:import>
