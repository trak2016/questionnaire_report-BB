<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:genericpage title="Rejestracja">

    <jsp:attribute name="html_extra_header">
        <link href="<c:url value="/resources/css/login.css"/>" rel="stylesheet">
    </jsp:attribute>

    <jsp:body>

        <div class="container">

            <div class="page-header">
                <h1>Rejstracja</h1>
            </div>

            <c:url value="/app/registration/formAction" var="action"/>
            <form:form cssclass="form-hirizontal" action="${action}" method="post"
                       modelAttribute="registrationForm" id="registrationForm">
                <fieldset>

                    <div class="form-group">
                        <label class="control-label" for="email">Adres e-mail</label>

                        <div class="controls">
                            <form:input path="email" id="email" placeholder="Adres e-mial"
                                        cssClass="form-control" type="email"/>

                            <p class="error"><form:errors path="email"/></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="password">Hasło</label>

                        <div class="controls">
                            <form:password path="password" id="password" placeholder="Hasło"
                                           cssClass="form-control"/>

                            <p class="error"><form:errors path="password"/></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label" for="password2">Hasło (potwierdzenie)</label>

                        <div class="controls">
                            <form:password path="password2" id="password2" placeholder="Hasło (potwierdzenie)"
                                           cssClass="form-control"/>

                            <p class="error"><form:errors path="password2"/></p>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="controls">
                            <input type="submit" class="btn btn-success" value="Rejestruj"/>
                        </div>
                    </div>
                </fieldset>
            </form:form>

        </div>

    </jsp:body>

</t:genericpage>
