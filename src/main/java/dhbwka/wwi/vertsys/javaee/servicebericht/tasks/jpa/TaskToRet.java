/*
 * Copyright © 2019 Patrick Gießler, Dominik Kunzmann, Daniel Wenzl
 * 
 * Dieser Quellcode ist lizenziert unter einer
 * Creative Commons Namensnennung 4.0 International Lizenz.
 */
package dhbwka.wwi.vertsys.javaee.servicebericht.tasks.jpa;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 *
 * @author PatrickGießler
 */
@Entity
public class TaskToRet implements Serializable {

    @Id
    private long id;

    @OneToOne
    private Category category;
    @Lob
    private String shortText;
    @Lob
    private String longText;

    // private TaskStatus status = TaskStatus.OPEN;
    public TaskToRet() {
    }

    public TaskToRet(Long id, Category cat, String sShortText, String sLongText) {
        this.id = id;
        this.category = cat;
        this.shortText = sShortText;
        this.longText = sLongText;
    }

    public long getId() {
        return id;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setShortText(String shortText) {
        this.shortText = shortText;
    }

    public void setLongText(String longText) {
        this.longText = longText;
    }

    public Category getCategory() {
        return category;
    }

    public String getShortText() {
        return shortText;
    }

    public String getLongText() {
        return longText;
    }

    public void setId(long id) {
        this.id = id;
    }

}
