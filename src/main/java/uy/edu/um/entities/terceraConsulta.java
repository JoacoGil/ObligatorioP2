package uy.edu.um.entities;

import uy.edu.um.tads.hash.MyHashImpl;
import uy.edu.um.tads.linkedlist.MyList;
import uy.edu.um.tads.linkedlist.MyLinkedListImpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class terceraConsulta {
    private DataStorage dataStorage;

    public terceraConsulta(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void ejecutarConsulta(LocalDate fechaInicio, LocalDate fechaFin) {
        MyList<EntradaTop50> entradas = dataStorage.getEntradasPorRangoDeFechas(fechaInicio, fechaFin);
        if (entradas.size() == 0) {
            System.out.println("No se encontraron canciones para el rango de fechas especificado.");
            return;
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < entradas.size(); i++) {
            EntradaTop50 entrada = entradas.get(i);
            MyList<Artista> artistas = entrada.getCancion().getArtistas();
            for (int j = 0; j < artistas.size(); j++) {
                String nombreArtista = artistas.get(j).getNombre();
                countMap.put(nombreArtista, countMap.getOrDefault(nombreArtista, 0) + 1);
            }
        }

        MyList<Map.Entry<String, Integer>> top7List = new MyLinkedListImpl<>();
        countMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(7)
                .forEach(top7List::add);

        printTop7Artists(top7List);
    }

    private void printTop7Artists(MyList<Map.Entry<String, Integer>> top7Artists) {
        System.out.println("Top 7 artistas:");
        for (int i = 0; i < top7Artists.size(); i++) {
            Map.Entry<String, Integer> entry = top7Artists.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " apariciones");
        }
    }
}
