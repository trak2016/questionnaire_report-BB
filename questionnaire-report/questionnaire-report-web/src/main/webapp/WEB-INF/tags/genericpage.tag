<%@ tag description="Overall Page template" pageEncoding="UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ attribute name="header" fragment="true" %>
<%@ attribute name="footer" fragment="true" %>
<%@ attribute name="html_extra_header" required="false" fragment="true" %>
<%@ attribute name="html_extra_footer" required="false" fragment="true" %>
<%@ attribute name="title" required="true" %>
<!DOCTYPE html>
<html lang="pl">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Questionnaire-report :: ${title}</title>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/themes/start/jquery-ui.min.css" rel="stylesheet">
    <link href="<c:url value="/resources/css/general.css"/>" rel="stylesheet">
    <link href='//fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,700italic,400,700,600&subset=latin-ext,latin'
          rel='stylesheet' type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Cardo:400,700&subset=latin,latin-ext' rel='stylesheet'
          type='text/css'>
    <link href='//fonts.googleapis.com/css?family=Asap&subset=latin,latin-ext' rel='stylesheet' type='text/css'>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
    <script type="text/javascript" src="//ajax.googleapis.com/ajax/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
    <script type="text/javascript" src="//cdn.datatables.net/1.10.0/js/jquery.dataTables.js"></script>
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js" type="text/javascript"></script>

    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js" type="text/javascript"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js" type="text/javascript"></script>
    <![endif]-->

    <jsp:invoke fragment="html_extra_header"/>

</head>
<body>

<div class="container">
    <jsp:doBody/>
</div>

<script>
    var baseUrl = '<c:url value="/" />';
</script>
<script type="text/javascript" src="<c:url value="/resources/js/general.js" />"></script>

<jsp:invoke fragment="html_extra_footer"/>

</body>
</html>
