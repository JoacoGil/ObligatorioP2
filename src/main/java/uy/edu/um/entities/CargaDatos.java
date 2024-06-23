package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyLinkedListImpl;
import uy.edu.um.tads.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

public class CargaDatos {
    public MyList<EntradaTop50> cargarDatosTop50(String archivo) {
        MyList<EntradaTop50> entradas = new MyLinkedListImpl<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            boolean isFirstLine = true; // Bandera para ignorar la primera línea si es un encabezado
            while ((line = br.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue; // Ignorar la primera línea
                }

                String[] values = line.split(",\"");

                if (values.length < 24) { // Verificar que haya suficientes campos
                    System.out.println("Línea inválida (menos de 24 campos): " + line);
                    continue;
                }

                try {
                    String nombreCancion = values[1].replaceAll("\"", "").trim();
                    String[] nombreArtista = values[2].replaceAll("\"", "").trim().split(", ");
                    MyList<Artista> artistasCancion = new MyLinkedListImpl<>();
                    for (String artista : nombreArtista) {
                        artistasCancion.add(new Artista(artista.trim()));
                    }
                    int posicion = Integer.parseInt(values[3].replaceAll("\"", "").trim());

                    String pais = values[6].replaceAll("\"", "").trim();
                    LocalDate fecha = LocalDate.parse(values[7].replaceAll("\"", "").trim());
                    double tempo = Double.parseDouble(values[23].replaceAll("\"", "").trim());

                    Cancion cancion = new Cancion(nombreCancion, artistasCancion, tempo);
                    EntradaTop50 entrada = new EntradaTop50(cancion, posicion, pais, fecha);
                    entradas.add(entrada);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error al procesar la línea: " + line);
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entradas;
    }
}
