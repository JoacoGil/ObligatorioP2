package uy.edu.um.entities;

import uy.edu.um.tads.hash.MyHashImpl;
import uy.edu.um.tads.linkedlist.MyList;
import uy.edu.um.tads.linkedlist.MyLinkedListImpl;

import java.time.LocalDate;

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

        MyHashImpl<String, Integer> countMap = new MyHashImpl<>();
        for (int i = 0; i < entradas.size(); i++) {
            EntradaTop50 entrada = entradas.get(i);
            MyList<Artista> artistas = entrada.getCancion().getArtistas();
            for (int j = 0; j < artistas.size(); j++) {
                String nombreArtista = artistas.get(j).getNombre();
                if (countMap.contains(nombreArtista)) {
                    countMap.put(nombreArtista, countMap.get(nombreArtista) + 1);
                } else {
                    countMap.put(nombreArtista, 1);
                }
            }
        }

        // Crear una lista de entradas para el top 7
        MyList<SimpleEntry<String, Integer>> top7List = new MyLinkedListImpl<>();
        MyList<String> keys = countMap.keys();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Integer value = countMap.get(key);
            top7List.add(new SimpleEntry<>(key, value));
        }

        // Ordenar manualmente la lista top7List
        MyList<SimpleEntry<String, Integer>> sortedList = sortList(top7List);

        // Limitar a los primeros 7 elementos
        MyList<SimpleEntry<String, Integer>> limitedTop7List = new MyLinkedListImpl<>();
        for (int i = 0; i < Math.min(7, sortedList.size()); i++) {
            limitedTop7List.add(sortedList.get(i));
        }

        printTop7Artists(limitedTop7List);
    }

    private MyList<SimpleEntry<String, Integer>> sortList(MyList<SimpleEntry<String, Integer>> list) {
        MyList<SimpleEntry<String, Integer>> sortedList = new MyLinkedListImpl<>();
        while (!list.isEmpty()) {
            SimpleEntry<String, Integer> maxEntry = null;
            int maxIndex = -1;

            for (int i = 0; i < list.size(); i++) {
                SimpleEntry<String, Integer> entry = list.get(i);
                if (maxEntry == null || entry.getValue() > maxEntry.getValue()) {
                    maxEntry = entry;
                    maxIndex = i;
                }
            }

            if (maxEntry != null) {
                sortedList.add(maxEntry);
                list.remove(maxEntry);
            }
        }
        return sortedList;
    }

    private void printTop7Artists(MyList<SimpleEntry<String, Integer>> top7Artists) {
        System.out.println("Top 7 artistas:");
        for (int i = 0; i < top7Artists.size(); i++) {
            SimpleEntry<String, Integer> entry = top7Artists.get(i);
            System.out.println((i + 1) + ". " + entry.getKey() + " - " + entry.getValue() + " apariciones");
        }
    }

    // Clase SimpleEntry para almacenar las entradas
    private static class SimpleEntry<K, V> {
        private K key;
        private V value;

        public SimpleEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
