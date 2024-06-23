package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyList;

public class Cancion {
    private String nombre;
    private MyList<Artista> artistas;
    private double tempo;

    public Cancion(String nombre, MyList<Artista> artistas, double tempo) {
        this.nombre = nombre;
        this.artistas = artistas;
        this.tempo = tempo;
    }

    public String getNombre() {
        return nombre;
    }

    public MyList<Artista> getArtistas() {
        return artistas;
    }

    public double getTempo() {
        return tempo;
    }
}
