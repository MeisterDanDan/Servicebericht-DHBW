<%-- 
    Document   : profilverwaltung
    Created on : 01.04.2019, 14:42:29
    Author     : Dominik Kunzmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/templates" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<template:base>
    <jsp:attribute name="title">
        Profilverwaltung
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/profilverwaltung.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>
        
        <c:if test="${user.admin}">
                <div class="menuitem">
                            <a href="<c:url value="/app/nutzerverwaltung/"/>">Nutzerverwaltung</a>
                </div>
        </c:if>
    </jsp:attribute>

    <jsp:attribute name="content">
        <form method="post" class="stacked">
        <div class="column">
                <%-- CSRF-Token --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">

                <%-- Eingabefelder --%>
                <label for="benutzerN">Benutzername:</label>
                <div class="side-by-side">
                    <input type="text" name="benutzerN" value="${user.username}" readonly="readonly">
                </div>
                
                <label for="vornameU">Vorname:</label>
                <div class="side-by-side">
                    <input type="text" name="vornameU" value="${user.vorname}">
                </div>

                <label for="nachnameU">Nachname:</label>
                <div class="side-by-side">
                    <input type="text" name="nachnameU" value="${user.nachname}">
                </div>
                
                <label for="telefonnummer">Telefonnummer: </label>
                <div class="side-by-side">
                    <input type="text" name="telefonnummer" value="${user.telefonnummer}">
                </div>

                

                <%-- Button zum Abschicken --%>
                <div class="side-by-side">
                    <button class="icon-pencil" type="submit" name="action" value="save">
                        Sichern
                    </button>

                    <c:if test="${edit}">
                        <button class="icon-trash" type="submit" name="action" value="delete">
                            Löschen
                        </button>
                    </c:if>
                </div>
            </div>

            <%-- Fehlermeldungen --%>
            <c:if test="${!empty task_form.errors}">
                <ul class="errors">
                    <c:forEach items="${task_form.errors}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </c:if>
        </form>
    </jsp:attribute>
</template:base>