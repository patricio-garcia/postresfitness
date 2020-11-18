package cl.desafiolatam.postresfitness.model;

import java.io.Serializable;

public class itemList implements Serializable {
    private String titulo, descripcion;
    private int imgResource;

    public itemList(String titulo, String descripcion, int imgResource) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imgResource = imgResource;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getImgResource() {
        return imgResource;
    }
}
