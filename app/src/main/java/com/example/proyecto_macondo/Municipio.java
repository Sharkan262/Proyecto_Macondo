package com.example.proyecto_macondo;

import java.io.Serializable;

public class Municipio implements Serializable{
    String Imagen;
    String nombreMun;


    public Municipio(String nombreMun,String imagMun) {
        this.nombreMun = nombreMun;
        this.Imagen = imagMun;
    }

    public String getImagen() {
        return Imagen;
    }

    public void setImagen(String imagen) {
        Imagen = imagen;
    }

    public String getNombreMun() {
        return nombreMun;
    }

    public void setNombreMun(String nombreMun) {
        this.nombreMun = nombreMun;
    }


}

