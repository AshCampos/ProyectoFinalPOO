package org.example.modelo;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

public class Naruto {
    private int id;
    private String personaje;
    private String ocupacion;
    private String aldea;
    private String clan;
    private String url;

    public Naruto() {
    }

    public Naruto(int id, String personaje, String ocupacion, String aldea, String clan, String url) {
        this.id = id;
        this.personaje = personaje;
        this.ocupacion = ocupacion;
        this.aldea = aldea;
        this.clan = clan;
        this.url = url;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getPersonaje() {

        return personaje;
    }

    public void setPersonaje(String personaje) {

        this.personaje = personaje;
    }

    public String getOcupacion() {

        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {

        this.ocupacion = ocupacion;
    }

    public String getAldea() {

        return aldea;
    }

    public void setAldea(String aldea) {

        this.aldea = aldea;
    }

    public String getClan() {

        return clan;
    }

    public void setClan(String clan) {

        this.clan = clan;
    }

    public String getUrl() {

        return url;
    }

    public void setUrl(String url) {

        this.url = url;
    }

    @Override
    public String toString() {
        return "Naruto{" +
                "id=" + id +
                ", personaje='" + personaje + '\'' +
                ", ocupacion='" + ocupacion + '\'' +
                ", aldea='" + aldea + '\'' +
                ", clan='" + clan + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
    public ImageIcon getImagen() throws MalformedURLException {
        URL urlImagen = new URL(this.url);
        return new ImageIcon(urlImagen);
    }
}
