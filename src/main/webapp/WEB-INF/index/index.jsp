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
       <c:choose>
            <c:when test="${!empty AlleFahrzeuge.responseList}">
                <c:forEach items="${AlleFahrzeuge.responseList}" var="fahrzeug">
                    <div class="card mb-3" style="max-width: 1000px;">
                        <div class="row no-gutters">
                            <div class="col-md-4 herstellerLogo">
                                <c:choose>
                                    <c:when test="${fahrzeug.bild == null}">
                                        <img src="<c:url value="/pictures/hersteller/${fahrzeug.hersteller}.png"/>" class="card-img mx-auto"
                                             style="min-height: 110px; max-height: 110px; width:auto; max-width: 100%;" alt="Herstellerbild">
                                    </c:when>
                                    <c:otherwise>
                                        <img src="<c:url value='${fahrzeug.bild}'/>" class="card-img" alt="Fahrzeugbild">
                                    </c:otherwise>
                                </c:choose>
                            </div>
                            <div class="col-md-4">
                                <div class="card-body">
                                    <h5 class="card-title">${fahrzeug.hersteller} ${fahrzeug.modell}</h5>
                                    <p class="card-text">Getriebe: ${fahrzeug.getriebeart}</p>
                                    <a href="<c:url value="/detail/${fahrzeug.id}/"/>">
                                        <button class="btn btn-primary btn-sm">
                                            Details
                                        </button>
                                    </a>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="card-body">
                                    <p class="card-text">Preis/Tag: ${fahrzeug.preisProTag}</p>
                                    <p class="card-text">Sitzplätze: ${fahrzeug.plaetze}</p>
                                    <c:if test="${mitarbeiter.response == null}">
                                        <c:if test="${kunde.response == null}">
                                            <a href="<c:url value="/login"/>">
                                                <button type="button" class="btn btn-primary btn-sm">Buchen</button>
                                            </a>
                                        </c:if>
                                        <c:if test="true">
                                            <a href="<c:url value="/book/${fahrzeug.id}/"/>">
                                                <button type="button" class="btn btn-primary btn-sm">Buchen</button>
                                            </a>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </c:when> 
            <c:otherwise>
                <%-- Hinweis, dass es noch keine Fahrzeuge gibt --%>
                <div class="alert alert-danger" role="alert">
                    Es sind noch keine Fahrzeuge vorhanden.
                </div>
            </c:otherwise>
        </c:choose>
    </jsp:attribute>
</template:base>