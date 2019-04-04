<%-- 
    Document   : nutzerverwaltung
    Created on : 02.04.2019, 10:54:46
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
        <link rel="stylesheet" href="<c:url value="/css/nutzerverwaltung.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/app/dashboard/"/>">Dashboard</a>
        </div>
        
        <div class="menuitem">
            <a href="<c:url value="/app/profil/"/>">Profilverwaltung</a>
        </div>

    </jsp:attribute>

        <jsp:attribute name="content">
            <form method="post" class="stacked">
                <%-- CSRF-Token --%>
                <input type="hidden" name="csrf_token" value="${csrf_token}">
                
             <%-- Vorhandene User --%>
                <c:choose>
                    <c:when test="${empty userList}">
                        <p>
                            Es sind noch keine User vorhanden!
                        </p>
                    </c:when>
                    <c:otherwise>
                        <div>
                            <div class="margin">
                                
                                        <table>
                                            <thead>
                                                <tr>
                                                    <th>Rechtevergabe</th>
                                                    <th>Username</th>
                                                    <th>Administratorrecht</th>
                                                </tr>
                                            </thead>
                                            <c:forEach items="${userList}" var="user">
                                                <c:if test="${userI.username != user.username}">
                                                    <tbody>
                                                        <tr>
                                                            <td>
                                                                <input type="checkbox" name="user" id="${'user-'.concat(user.username)}" value="${user.username}" />
                                                                <label for="${'user-'.concat(user.username)}">
                                                            </td>
                                                            <td>
                                                                <c:out value="${user.vorname}"/>
                                                            </td>
                                                            <td>
                                                                <c:out value="${user.admin}"/>
                                                            </td>
                                                        </tr>
                                                    </tbody>
                                                </c:if>
                                            </c:forEach>
                                        </table>
                                    </label>
                                    <br />
                                
                            </div>

                            <button type="submit" name="action" value="submit" class="icon-trash">
                                Administratorrechte vergeben
                            </button>
                            <button type="submit" name="action" value="remove" class="icon-trash">
                                Administratorrechte entfernen
                            </button>
                            
                        </div>
                    </c:otherwise>
                </c:choose>
            </form>
          
    </jsp:attribute>
</template:base>
