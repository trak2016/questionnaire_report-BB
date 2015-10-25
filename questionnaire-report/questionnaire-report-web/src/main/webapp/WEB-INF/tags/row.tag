<%@ tag description="One row tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="description" required="true" type="java.lang.String" %>
<%@ attribute name="value" required="true" type="java.lang.Object" %>
<%@ attribute name="isDate" required="false" type="java.lang.Boolean" %>
<%@ attribute name="isPerson" required="false" type="java.lang.Boolean" %>
<%@ attribute name="isBoolean" required="false" type="java.lang.Boolean" %>
<%@ attribute name="isCollection" required="false" type="java.lang.Boolean" %>

<div class="row">
    <div class="col-md-3">
        <p>${description}</p>
    </div>
    <div class="col-md-9">
        <c:choose>
            <c:when test="${isDate}">
                <t:date field="${value}"/>
            </c:when>

            <c:when test="${isBoolean}">
                <t:boolean value="${value}"/>
            </c:when>

            <c:when test="${isCollection}">
                <c:forEach items="${value}" var="element">
                    ${element.name}<br/>
                </c:forEach>
            </c:when>

            <c:otherwise>
                <p>${value}</p>
            </c:otherwise>
        </c:choose>
    </div>
</div>
