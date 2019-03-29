<%-- 
    Document   : servicedetail
    Created on : 29.03.2019, 10:03:40
    Author     : Daniel Wenzl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<template:base>
    <jsp:attribute name="title">
        Anlegen
    </jsp:attribute>

    <jsp:attribute name="head">
        <link rel="stylesheet" href="<c:url value="/css/service.css"/>" />
    </jsp:attribute>

    <jsp:attribute name="menu">
        <div class="menuitem">
            <a href="<c:url value="/newServicebericht"/>">Servicebericht anlegen</a>
        </div>
    </jsp:attribute>

    <jsp:attribute name="content">
        <form method="POST">
            <div class="card">
                <div class="card-body mb-3 mt-3">
                    <div class="form-row">
                        <label for="thema">Thema: </label>
                        <select name="thema" class="form-control form-control-sm" required>
                            <option value="" disabled selected style="display: none;">Bitte Thema wählen</option>
                            <c:forEach items="${themaList}" var="themaValue">
                                <option value="${themaValue}" ${themaValue == detailService.response.thema ? 'selected' : ''}>
                                    ${themaValue}
                                </option>
                            </c:forEach>
                        </select>
                        
                        <label for="beschreibung">Beschreibung: </label>
                            <input name="beschreibung" type="text" class="form-control form-control-sm" required
                                   value="${detailService.response.beschreibung}"</input>
                            
                        <label for="ort">Ort: </label>
                            <input name="ort" type="text" class="form-control form-control-sm" required
                                   value="${detailService.response.ort}"</input>
                            
                    </div>
                </div>
            </div>
        </form>
    </jsp:attribute>
</template:base>
