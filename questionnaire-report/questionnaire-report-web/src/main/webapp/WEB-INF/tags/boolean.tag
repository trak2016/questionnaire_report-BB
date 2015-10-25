<%@ tag description="Returns Yes or No for boolean variable" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="value" required="true" type="java.lang.Boolean" %>

<c:choose>
    <c:when test="${value}">
        Tak
    </c:when>

    <c:otherwise>
        Nie
    </c:otherwise>
</c:choose>
