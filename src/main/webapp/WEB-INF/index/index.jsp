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
        <div class="menuitem">
            <a href="<c:url value="/newServicebericht"/>">Servicebericht anlegen</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        
        <c:choose>
            <c:when test="${!empty ServiceResponse.responseList}">
                <c:forEach items="${ServiceResponse.responseList}" var="serviceeintrag">
                    <div class="card mb-3" style="max-width: 1000px">
                        <div class="row no-gutters">
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
                        </div>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <%-- Hinweis, dass es noch keine Einträge gibt --%>
                <div class="alert alert-danger" role="alert">
                    Es sind noch keine Berichte vorhanden.
                </div>
            </c:otherwise>
            </c:choose>
        
    </jsp:attribute>
</template:base>