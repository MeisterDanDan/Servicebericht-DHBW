/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.jpa;

import de.statusbericht.dhbw.enums.ServiceStatus;
import de.statusbericht.dhbw.enums.ServiceThema;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Dominik Kunzmann
 */
@Entity
public class Serviceeintrag implements Serializable{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "kommentar_id")
    private Kommentar kommentar;

    private ServiceThema thema;

    private String bild;

    private String ort;

    private String beschreibung;

    private ServiceStatus status;

    private int zustimmung;

    public ServiceThema getThema() {
        return thema;
    }

    public void setThema(ServiceThema thema) {
        this.thema = thema;
    }

    public String getBild() {
        return bild;
    }

    public void setBild(String bild) {
        this.bild = bild;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public ServiceStatus getStatus() {
        return status;
    }

    public void setStatus(ServiceStatus status) {
        this.status = status;
    }

    public int getZustimmung() {
        return zustimmung;
    }

    public void setZustimmung(int zustimmung) {
        this.zustimmung = zustimmung;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Kommentar getKommentar() {
        return kommentar;
    }

    public void setKommentar(Kommentar kommentar) {
        this.kommentar = kommentar;
    }
}
