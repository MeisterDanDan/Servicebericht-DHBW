<%-- 
    Document   : index
    Created on : 26.03.2019, 15:23:10
    Author     : Dominik Kunzmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Übersicht
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/index.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        
    </jsp:attribute>

    <jsp:attribute name="content">
       <div>
            <label for="administrator">Administrator: </label>
            <input name="administrator" type="text" class="form-control form-control-sm" value="${administrator.response.nickName}" required></input>
        </div>
    </jsp:attribute>
</template:base>