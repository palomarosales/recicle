package com.proyecto.model;

public class Pais {
    private String nombre;
    private String capital;
    private String bandera;
    private String poblacion;
    private String mapa;
    private String himno;


    public Pais(String nombre, String capital, String bandera, String poblacion, String mapa, String himno) {
        this.nombre = nombre;
        this.capital = capital;
        this.bandera = bandera;
        this.poblacion = poblacion;
        this.mapa = mapa;
        this.himno = himno;
    }

    public String getHimno() {
        return himno;
    }

    public void setHimno(String himno) {
        this.himno = himno;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getBandera() {
        return bandera;
    }
    public void setBandera(String bandera) {
        this.bandera = bandera;
    }


    public String getCapital() {
        return capital;
    }
    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPoblacion() {
        return poblacion;
    }
    public void setPoblacion(String poblacion) {
        this.capital = poblacion;
    }


    public String getMapa() {
        return mapa;
    }
    public void setMapa(String mapa) {
        this.mapa = mapa;
    }



}



