Beispielanwendung "Servicebericht DHBW"
=========================

Anleitung zur Anlage des ersten Administrators:
1. User über die Webanwendung registrieren
2. In Netbeans in der Datenbank folgendes Statement reinkopieren, Benutzername anpassen und dann Run SQL drücken:
    ,,UPDATE SERVICEBERICHT.SERVICEBERICHT_USER SET ADMIN=1 WHERE USERNAME ='hier muss der Benutzername stehen';"

------------------

Kurzbeschreibung:
Studenten der DHBW haben über die Webanwendung die Möglichkeit, Mängel an ihrer dualen Hochschule durch das Anlegen von Serviceberichten den Hausmeistern melden zu können. Um die Sicherheit der Daten zu gewährleisten, gibt es einen vor die Webanwendung geschalteten Login Bereich für Studenten und Hausmeister. Auf der Startseite werden die Serviceberichte nach den Kategorien gefiltert, welche zuvor von einem Administrator angelegt wurden. Folgende Kategorien wären für die DHBW denkbar: ,,Alle Kategorien, Technik, Raum und Sonstiges“. Innerhalb dieser Kategorien sind die Serviceberichte in die Status: ,,Alle, Offen, In Bearbeitung und Erledigt“ eingeteilt. Die dort enthaltenen Serviceberichte können über eine REST-Schnittstelle als JSON Objekte angezeigt werden. Der Hausmeister besitzt als Administrator zusätzliche Funktionen. Er kann bestehende Kategorien löschen, neue Kategorien anlegen, registrierten Nutzern Administratorrechte vergeben und Serviceberichte löschen.

----------------

Dies ist ein Beispiel für eine in Java realisierte, serverseitige MVC-Webanwendung.
Die Anwendung setzt dabei ganz klassisch auf der „Jakarta Enterprise Edition”
(ehemals „Java Enterprise Edition“) auf und läuft daher in einem speziell dafür
ausgelegten Applikationsserver. Sämtliche Anwendungslogik wird dabei vom Server
implementiert, so dass für jedes URL-Pattern der Anwendung ein komplett serverseitig
generierte HTML-Seite abgerufen und im Browser dargestellt wird.

Verwendete Technologien
-----------------------

Die App nutzt Maven als Build-Werkzeug und zur Paketverwaltung. Auf diese Weise
werden die für Jakarta EE notwendigen APIs, darüber hinaus aber keine weiteren
Abhängigkeiten, in das Projekt eingebunden. Der Quellcode der Anwendung ist dabei
wie folgt strukturiert:

 * **Servlets** dienen als Controller-Schicht und empfangen sämtliche HTTP-Anfragen.
 * **Enterprise Java Beans** dienen als Model-Schicht und kapseln die fachliche Anwendungslogik.
 * **Persistence Entities** modellieren das Datenmodell und werden für sämtliche Datenbankzugriffe genutzt.
 * **Java Server Pages** sowie verschiedene statische Dateien bilden die View und generieren den
   auf dem Bildschirm angezeigten HTML-Code.

Folgende Entwicklungswerkzeuge kommen dabei zum Einsatz:

 * [NetBeans:](https://netbeans.apache.org/) Integrierte Entwicklungsumgebung für Java und andere Sprachen
 * [Maven:](https://maven.apache.org/) Build-Werkzeug und Verwaltung von Abhängigkeiten
 * [Git:](https://git-scm.com/") Versionsverwaltung zur gemeinsamen Arbeit am Quellcode
 * [TomEE:](https://tomee.apache.org/) Applikationsserver zum lokalen Testen der Anwendung
 * [Derby:](https://db.apache.org/derby/) In Java implementierte SQL-Datenbank zum Testen der Anwendung

Copyright
---------

Dieses Projekt ist lizenziert unter
[_Creative Commons Namensnennung 4.0 International_](http://creativecommons.org/licenses/by/4.0/)

© 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl <br/>
