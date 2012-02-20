<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<c:import url="layout.jsp">
  <c:param name="title" value="Tavi's Travelog - ${f:h(year) }"/>
  <c:param name="contentJsp" value="contentArchive.jsp" />
</c:import>