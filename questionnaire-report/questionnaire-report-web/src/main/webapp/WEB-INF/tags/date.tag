<%@ tag import="java.text.SimpleDateFormat" %>
<%@ tag description="Date tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="field" required="true" type="java.util.Date" %>
<%@ attribute name="format" required="false" type="java.lang.String" description="simple date format" %>

<%
    String dateFormat = "yyyy-MM-dd";
    if (format != null) {
        dateFormat = format;
    }
    SimpleDateFormat dateFormatWithTime = new SimpleDateFormat(dateFormat);
%>
<%=dateFormatWithTime.format(field)%>
