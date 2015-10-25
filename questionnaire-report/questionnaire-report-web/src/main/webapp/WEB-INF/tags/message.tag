<%@tag description="View message" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty message}">
    <div class="alert alert-success alert-dismissable">
            ${message}
    </div>
</c:if>
