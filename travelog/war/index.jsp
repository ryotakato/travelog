<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>

<c:import url="/common/layout.jsp">
  <c:param name="title" value="Tavi's Travelog"/>
  <c:param name="content">
  	<c:import url="entry.jsp"/>
  </c:param>
  <c:param name="javascript">
    <script type="text/javascript" lang="javascript">
    <!--
    $(document).ready(function() {
    	$("#comment-button").click(function() {
            var form = $("#comment-form");
            form.children('input[name=protect]').val("protect");
            form.submit();
    	});
    });
    // -->
    </script>
  </c:param>
</c:import>
