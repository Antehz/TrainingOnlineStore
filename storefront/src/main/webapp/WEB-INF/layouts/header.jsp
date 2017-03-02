<?xml version="1.0" encoding="UTF-8" standalone="no"?>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<spring:message code="header_text" var="headerText" />
<spring:message code="label_logout" var="labelLogout" />
<spring:message code="label_welcome" var="labelWelcome" />
<spring:url var="logoutUrl" value="/j_spring_security_logout" />

<div id="header" />

${headerText}

<a href="http://all-free-download.com/free-website-templates/">Forum</a>
|
<a href="http://all-free-download.com/free-website-templates/">Contact</a>
<div class="comment">
	Search the Web: <input type="text" name="search" class="search" /> <input
		type="submit" value="Search" class="submit" />
</div>

<%--  <div id="userinfo">
        <sec:authorize access="isAuthenticated()">${labelWelcome}
            <sec:authentication property="principal.username" />
            <br/>
            <a href="${logoutUrl}">${labelLogout}</a>
        </sec:authorize>
    </div>--%>
</div>
