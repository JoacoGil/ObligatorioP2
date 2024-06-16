package uy.edu.um.entities;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaTop50 {
    private Cancion cancion;
    private int posicion;
    private String pais;
    private LocalDate fecha;
}
