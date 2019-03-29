<%-- 
    Document   : index
    Created on : 26.03.2019, 15:23:10
    Author     : Dominik Kunzmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<template:base>
    <jsp:attribute name="title">
        Übersicht
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/index.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/newServicebericht"/>">Servicebericht anlegen</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
       <c:if test="${!empty serviceResponse.responseList}">
            <form method="POST">
                <div class="col-md-4 serviceeintrag">
                                <c:choose>
                                    <c:when test="${serviceeintrag.bild == null}">
                                        <img src="<c:url value="/img/logo.svg.png"/>" alt="Logo der DHBW" class="card-img mx-auto"
                                             style="min-height: 110px; max-height: 110px; width:auto; max-width: 100%;">
                                    </c:when>
                                </c:choose>
                            </div>
                            <div class="col-md-4">
                                <div class="card-body">
                                    <h5 class="card-title">${serviceeintrag.thema} ${serviceeintrag.status}</h5>
                                    <p class="card-text">Ort: ${serviceeintrag.ort}</p>
                                    <p class="card-text">Beschreibung: ${serviceeintrag.beschreibung}</p>
                                    <a href="<c:url value="/detail/${serviceeintrag.id}/"/>">
                                        <button class="btn btn-primary btn-sm">
                                            Details
                                        </button>
                                    </a>
                                </div>
                            </div>
            </form>
        </c:if>
    </jsp:attribute>
</template:base>