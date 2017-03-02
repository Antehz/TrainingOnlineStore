<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login page</title>
<spring:message code="label.username" var="username" />
<spring:message code="label.password" var="password" />
<spring:message code="welcome_titlepane" var="welcome" />
<spring:message code="label.notlogin" var="notlogin" />
</head>
<body>
	${welcome}
	<a href="<c:url value="/login"/>">${notlogin}</a>
</body>
</html>