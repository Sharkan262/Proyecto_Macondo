package com.example.proyecto_macondo;

import java.io.Serializable;

public class Departamento implements Serializable {

    String nombreDep;
    String imgDep;

    public Departamento(String nombreDep, String imgDep) {
        this.nombreDep = nombreDep;
        this.imgDep = imgDep;
    }
    public String getNombreDep() {
        return nombreDep;
    }

    public void setNombreDep(String nombreDep) {
        this.nombreDep = nombreDep;
    }

    public String getImgDep() {
        return imgDep;
    }

    public void setImgDep(String imgDep) {
        this.imgDep = imgDep;
    }



}
