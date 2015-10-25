<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Logowanie">

    <jsp:attribute name="html_extra_header">
        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>

        <div class="container">

            <div class="page-header">
                <h1>Dziękujemy za korzystanie z systemu</h1>
            </div>

            <div class="form-group">
                Proszę wybrać "Potwierdź" celem celem wylogowania się.
            </div>

            <div class="form-group">
                <c:url var="logoutValue" value="/app/auth/logout"/>
                <form action="${logoutValue}" method="POST">
                    <button class="btn btn-default" type="submit">Potwierdź</button>
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
            </div>

        </div>

    </jsp:body>

</t:genericpage>
