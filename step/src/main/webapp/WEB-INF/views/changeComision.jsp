<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
  </head>
  <body>
    <h1><fmt:message key="changeComision.heading"/></h1>
    <form:form method="post" commandName="changeComision">
      <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
        <br>
        id de la cuenta: <%=request.getParameter("id") %>  
        
        <tr>
           <td align="right" width="20%">comision (%):</td>
             <td width="20%">
          		<form:input path="comision"/>
        	 </td>
        </tr>
      </table>
      <br>
      <input type="submit" value="Execute">
    </form:form>
    
    <br>
    	<a href="<c:url value="accounts.htm"/>">listado de cuentas</a>
  </body>
</html>