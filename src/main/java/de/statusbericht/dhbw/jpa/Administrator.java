/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package de.statusbericht.dhbw.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

/**
 *
 * @author Dominik Kunzmann
 */

@Entity
public class Administrator implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nickName;

    private String email;
    
    private String passwort;
    
    @ElementCollection
    @CollectionTable(
            name = "USER_GROUP",
            joinColumns = @JoinColumn(name = "USERNAME")
    )
    @Column(name = "GROUPNAME")
    List<String> groups = new ArrayList<>();
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }
    
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Administrator{" + "id=" + id + ", Nickname: " + nickName + ", passwort=" + passwort + '}';
    }
    
}
