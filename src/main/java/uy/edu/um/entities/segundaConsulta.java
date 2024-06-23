package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyList;
import uy.edu.um.tads.linkedlist.MyLinkedListImpl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class segundaConsulta {
    private DataStorage dataStorage;

    public segundaConsulta(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void ejecutarConsulta(LocalDate fecha) {
        MyList<EntradaTop50> entradas = dataStorage.getEntradasPorFecha(fecha);
        if (entradas.size() == 0) {
            System.out.println("No se encontraron canciones para la fecha especificada.");
            return;
        }

        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < entradas.size(); i++) {
            EntradaTop50 entrada = entradas.get(i);
            String nombreCancion = entrada.getCancion().getNombre();
            countMap.put(nombreCancion, countMap.getOrDefault(nombreCancion, 0) + 1);
        }

        MyList<Map.Entry<String, Integer>> top5List = new MyLinkedListImpl<>();
        countMap.entrySet().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getValue(), e1.getValue()))
                .limit(5)
                .forEach(top5List::add);

        printTop5Songs(top5List);
    }

    private void printTop5Songs(MyList<Map.Entry<String, Integer>> top5Songs) {
        System.out.println("Top 5 canciones:");
        for (int i = 0; i < top5Songs.size(); i++) {
            Map.Entry<String, Integer> entry = top5Songs.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " apariciones");
        }
    }
}
