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
public enum ResponseStatus {
    ERROR("Error"),
    WARNUNG("Warnung"),
    FATALERROR("fataler Error"),
    ERFOLGREICH("Erfolgreich"),
    GELOESCHT("Gelöscht"),
    NULL("null");
    
    
    private String bezeichnung;
    
    private ResponseStatus(String bezeichnung){
        this.bezeichnung = bezeichnung;
    }
}
