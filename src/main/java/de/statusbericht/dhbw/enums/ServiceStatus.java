/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.enums;

/**
 *
 * @author Dominik Kunzmann
 */
public enum ServiceStatus {
    GESCHLOSSEN("Geschlossen"),
    INBEARBEITUNG("In Bearbeitung"),
    OFFEN("Offen");
    
    private String bezeichnung;
    
    private ServiceStatus(String str){
        this.bezeichnung = str;
    }
}
