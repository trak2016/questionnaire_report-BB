<%@ tag description="Pole checkbox" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ attribute name="path" required="true" %>
<%@ attribute name="label" required="false" type="java.lang.String" %>
<%@ attribute name="help" required="false" type="java.lang.String" %>

<spring:bind path="${path}">
    <div class="form-group ${status.error ? 'has-error' : '' }">
        <div class="col-md-3 control-label"></div>
        <div class="col-md-4">
            <label>
                <form:checkbox path="${path}"/> ${label}</label>

            <div class="help-block">
                <c:if test="${not empty help}">
                    <div>${help}</div>
                </c:if>

                <c:if test="${status.error}">
                    <div class="error-text">${status.errorMessage}</div>
                </c:if>
            </div>
        </div>

    </div>
</spring:bind>