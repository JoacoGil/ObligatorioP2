package uy.edu.um.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uy.edu.um.tads.linkedlist.MyList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cancion {
    private String nombre;
    private MyList<Artista> artists;
    private double tempo;
}
