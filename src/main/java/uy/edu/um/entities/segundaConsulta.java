package uy.edu.um.entities;

import uy.edu.um.tads.hash.MyHashImpl;
import uy.edu.um.tads.linkedlist.MyList;
import uy.edu.um.tads.linkedlist.MyLinkedListImpl;

import java.time.LocalDate;

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

        MyHashImpl<String, Integer> countMap = new MyHashImpl<>();
        for (int i = 0; i < entradas.size(); i++) {
            EntradaTop50 entrada = entradas.get(i);
            String nombreCancion = entrada.getCancion().getNombre();
            if (countMap.contains(nombreCancion)) {
                countMap.put(nombreCancion, countMap.get(nombreCancion) + 1);
            } else {
                countMap.put(nombreCancion, 1);
            }
        }

        // Crear una lista de entradas para el top 5
        MyList<SimpleEntry<String, Integer>> top5List = new MyLinkedListImpl<>();
        MyList<String> keys = countMap.keys();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            Integer value = countMap.get(key);
            top5List.add(new SimpleEntry<>(key, value));
        }

        // Ordenar manualmente la lista top5List
        MyList<SimpleEntry<String, Integer>> sortedList = sortList(top5List);

        // Limitar a los primeros 5 elementos
        MyList<SimpleEntry<String, Integer>> limitedTop5List = new MyLinkedListImpl<>();
        for (int i = 0; i < Math.min(5, sortedList.size()); i++) {
            limitedTop5List.add(sortedList.get(i));
        }

        printTop5Songs(limitedTop5List);
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

    private void printTop5Songs(MyList<SimpleEntry<String, Integer>> top5Songs) {
        System.out.println("Top 5 canciones:");
        for (int i = 0; i < top5Songs.size(); i++) {
            SimpleEntry<String, Integer> entry = top5Songs.get(i);
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
