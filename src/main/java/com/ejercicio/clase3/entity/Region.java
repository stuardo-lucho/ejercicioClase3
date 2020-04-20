package com.ejercicio.clase3.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "region")
public class Region {

    @Id
    private int regionid;
    @Column(nullable = false)
    private String regiondescription;

    public int getRegionid() {
        return regionid;
    }

    public void setRegionid(int regionid) {
        this.regionid = regionid;
    }

    public String getRegiondescription() {
        return regiondescription;
    }

    public void setRegiondescription(String regiondescriotion) {
        this.regiondescription = regiondescriotion;
    }
}
