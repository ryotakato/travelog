<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<c:import url="layout.jsp">
  <c:param name="title" value="Tavi's Travelog - ${f:h(name) }"/>
  <c:param name="contentJsp" value="contentCategory.jsp" />
</c:import>