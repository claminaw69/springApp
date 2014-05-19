<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <h3>Accounts</h3>
    <c:forEach items="${model.accounts}" var="acc">      
      <br>
    	<a href="<c:url value="changeComision.htm?id=${acc.id}"/>">Cuenta: ${acc.id} ----> Comision: ${acc.comision}%</a>
      <br>
    </c:forEach>
  </body>
</html>