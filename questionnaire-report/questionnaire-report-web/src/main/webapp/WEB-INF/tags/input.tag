<%@tag description="Extended input tag to allow for sophisticated errors" pageEncoding="UTF-8" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@attribute name="path" required="true" type="java.lang.String" %>
<%@attribute name="cssClass" required="false" type="java.lang.String" %>
<%@attribute name="divCssClass" required="false" type="java.lang.String" %>
<%@attribute name="label" required="false" type="java.lang.String" %>
<%@attribute name="required" required="false" type="java.lang.Boolean" %>
<%@attribute name="readonly" required="false" type="java.lang.Boolean" %>
<%@attribute name="help" required="false" type="java.lang.String" %>
<%@attribute name="placeholder" required="false" type="java.lang.String" %>
<%@attribute name="isPassword" required="false" type="java.lang.Boolean" %>
<%@attribute name="isDate" required="false" type="java.lang.Boolean" %>
<%@attribute name="type" required="false" type="java.lang.String" %>
<%@attribute name="step" required="false" type="java.lang.String" %>
<%@attribute name="min" required="false" type="java.lang.Integer" %>
<%@attribute name="max" required="false" type="java.lang.Integer" %>

<c:if test="${empty type}">
    <c:set var="type" value="text"/>
</c:if>

<c:if test="${empty label}">
    <c:set var="label"
           value="${fn:toUpperCase(fn:substring(path, 0, 1))}${fn:toLowerCase(fn:substring(path, 1,fn:length(path)))}"/>
</c:if>
<spring:bind path="${path}">
    <div class="control-group form-group ${divCssClass} ${status.error ? 'has-error' : '' }">
        <label class="control-label" for="${path}">${label}
            <c:if test="${required == true}"><span class="required">*</span></c:if>
            <c:if test="${status.error}">
                <span class="error-text">${status.errorMessage}</span>
            </c:if>
        </label>

        <div
                <c:choose>
                    <c:when test="${isDate==true}">
                        class="input-group date" data-date-format="YYYY-MM-DD" data-date-pickTime="false" data-date-language="pl" data-date-useStrict="true"
                    </c:when>

                    <c:otherwise>
                        class="controls"
                    </c:otherwise>
                </c:choose>
                >

            <c:choose>

                <c:when test="${isPassword==true}">
                    <form:password readonly="${readonly ? 'true' : 'false'}" path="${path}"
                                   cssClass="${empty cssClass ? 'form-control' : cssClass}"/>
                </c:when>

                <c:when test="${empty placeholder}">
                    <form:input required="${required}" readonly="${readonly ? 'true' : 'false'}" path="${path}"
                                cssClass="${empty cssClass ? 'form-control' : cssClass}" type="${type}" step="${step}"
                                min="${min}" max="${max}"/>
                </c:when>

                <c:otherwise>
                    <form:input required="${required}" placeholder="${placeholder}"
                                readonly="${readonly ? 'true' : 'false'}" path="${path}"
                                cssClass="${empty cssClass ? 'form-control' : cssClass}" type="${type}" step="${step}"
                                min="${min}" max="${max}"/>
                </c:otherwise>
            </c:choose>
            <p class="help-block"></p>

            <c:if test="${isDate==true}">
                <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
            </c:if>

            <c:if test="${not empty help}"><span class="help-block">${help}</span></c:if>

        </div>
    </div>
</spring:bind>
