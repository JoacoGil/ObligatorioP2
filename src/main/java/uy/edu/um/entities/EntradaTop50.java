package uy.edu.um.entities;

import java.time.LocalDate;

public class EntradaTop50 {
    private Cancion cancion;
    private int posicion;
    private String pais;
    private LocalDate fecha;

    public EntradaTop50(Cancion cancion, int posicion, String pais, LocalDate fecha) {
        this.cancion = cancion;
        this.posicion = posicion;
        this.pais = pais;
        this.fecha = fecha;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public int getPosicion() {
        return posicion;
    }

    public String getPais() {
        return pais;
    }

    public LocalDate getFecha() {
        return fecha;
    }
}
