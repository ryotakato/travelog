<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>



<script type="text/javascript" lang="javascript">
alert("outer");
$(document).ready(function(){
	alert("aaaaaa");
	$("#aboutMe").hover(
		function() {
			$(this).attr('src','aboutme_s_hover.jpg');
		},
		function() {
			$(this).attr('src','aboutme_s.jpg');
		}
	);
}
</script>



<c:import url="layout.jsp">
  <c:param name="title" value="Tavi's Travelog"/>
  <c:param name="contentJsp" value="contentEntry.jsp" />
</c:import>
