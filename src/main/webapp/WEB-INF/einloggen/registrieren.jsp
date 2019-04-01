<%-- 
    Document   : registrieren
    Created on : 01.04.2019, 12:01:30
    Author     : Dominik Kunzmann
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib tagdir="/WEB-INF/tags/" prefix="template"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">


<template:base>
    <jsp:attribute name="title">Registrieren</jsp:attribute>
    <jsp:attribute name="content">
        <form method="POST">
            <div class="card" style="width:400px">
                <div class="card-body">
                    
                    <h4 class="card-title">Benutzername:</h4>
                    <input name="nickName" type="text" class="form-control form-control-sm"</input>
                    <br>
                    <h4 class="card-title">E-Mail:</h4>
                    <input name="email" type="text" class="form-control form-control-sm"</input>
                    <br>
                    <h4 class="card-title">Passwort:</h4>
                    <input name="passwort" type="password" class="form-control form-control-sm"</input>
                    <br>
                    <button type="submit" class="btn btn-success btn-sm m-3">Registrieren</button>
                    <br>
                    <a href="<c:url value="/"/>">
                        <button type="button" class="btn btn-primary btn-sm m-3">Zurück zur Übersicht</button>
                    </a>
                </div>
            </div>
        </form>
    </jsp:attribute>
</template:base>