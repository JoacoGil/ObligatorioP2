package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyList;
import java.time.LocalDate;

public class PrimeraConsulta {
    private DataStorage dataStorage;

    public PrimeraConsulta(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void ejecutarConsulta(String pais, LocalDate fecha) {
        MyList<EntradaTop50> top10Songs = dataStorage.getTop10Songs(pais, fecha);
        if (top10Songs.size() > 0) {
            printTop10Songs(top10Songs);
        } else {
            System.out.println("No se encontraron canciones para el país y la fecha especificados.");
        }
    }

    private void printTop10Songs(MyList<EntradaTop50> top10Songs) {
        System.out.println("Top 10 canciones:");
        for (int i = 0; i < top10Songs.size(); i++) {
            EntradaTop50 entry = top10Songs.get(i);
            System.out.println((i + 1) + ". " + entry.getCancion().getNombre() + " - " + entry.getCancion().getArtistas().get(0).getNombre() +
                    " (Posición: " + entry.getPosicion() + ")");
        }
    }
}
