<%-- 
    Document   : base
    Created on : 26.03.2019, 15:10:55
    Author     : Dominik Kunzmann
--%>

<%@tag pageEncoding="UTF-8"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<%@attribute name="title"%>
<%@attribute name="head" fragment="true"%>
<%@attribute name="menu" fragment="true"%>
<%@attribute name="main" fragment="true"%>
<%@attribute name="content" fragment="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />

        <title>Servicebericht: ${title}</title>

        
        <link rel="stylesheet" href="<c:url value="/fontello/css/fontello.css"/>" />
        <link rel="stylesheet" href="<c:url value="/css/bootstrap.min.css"/>" />
        <script src="<c:url value="/js/bootstrap.min.js"/>"></script>  
        <link rel="stylesheet" href="<c:url value="/css/main.css"/>" />
        
        

        <jsp:invoke fragment="head"/>
    </head>
    <body>
        <%-- Kopfbereich --%>
        <header>
            <%-- Titelzeile --%>
            <div id="titlebar">
                <a href="<c:url value="/"/>">
                    <div class="appname">
                        Servicebericht
                    </div>
                </a>
                <div class="content">
                    ${title}
                </div>
                
                
            </div>
                <div class="logo">
                    <img src="<c:url value="/img/logo.svg.png"/>" alt="Logo der DHBW"></img>
                </div>
                
            <div id="menubar">
                <jsp:invoke fragment="menu"/>
                
                
        <div class="menuitem">
            
                    <a href="<c:url value="/newServicebericht"/>">Servicebericht anlegen</a>
               
                    <c:if test="${administrator.response == null}">
                        <a href="<c:url value="/login"/>">
                            Login
                        </a>
                    </c:if>
                    <c:if test="${administrator.response != null}">
                        <a href="<c:url value="/logout"/>">
                            Abmelden
                        </a>
                    </c:if>
                
        </div>
  
            </div>
        </header>

        <%-- Hauptinhalt der Seite --%>
        <main class="background">    
            <div class="container p-3" style="min-height: 100%">
                <jsp:invoke fragment="content"></jsp:invoke>
                </div>
        </main>
    </body>
</html>