package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyList;
import java.time.LocalDate;
//
public class cuartaConsulta {
    private DataStorage dataStorage;

    public cuartaConsulta(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void ejecutarConsulta(String artista, LocalDate fecha) {
        MyList<EntradaTop50> entradas = dataStorage.getEntradasPorFecha(fecha);
        if (entradas.size() == 0) {
            System.out.println("No se encontraron canciones para la fecha especificada.");
            return;
        }

        int count = 0;
        for (int i = 0; i < entradas.size(); i++) {
            EntradaTop50 entrada = entradas.get(i);
            MyList<Artista> artistas = entrada.getCancion().getArtistas();
            for (int j = 0; j < artistas.size(); j++) {
                if (artistas.get(j).getNombre().equalsIgnoreCase(artista.trim())) {
                    count++;
                }
            }
        }

        System.out.println("El artista " + artista + " aparece " + count + " veces en el top 50 el día " + fecha + ".");
    }
}
