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
public enum ServiceThema {
    TECHNIK("Technik"),
    RAUM("Raum"),
    SONSTIGES("Sonstiges");
    
    private String bezeichnung;
    
    private ServiceThema(String str){
        this.bezeichnung = str;
    }
}
