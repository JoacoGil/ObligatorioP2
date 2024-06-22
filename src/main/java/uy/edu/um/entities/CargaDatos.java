package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyLinkedListImpl;
import uy.edu.um.tads.linkedlist.MyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;

public class CargaDatos {
    public MyList<EntradaTop50> cargarDatosTop50(String archivo){
        MyList<EntradaTop50> entradas = new MyLinkedListImpl<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",\"");


                String nombreCancion = values[1].replace("\"", "");
                String[] nombreArtista = values[2].replace("\"", "").split(", ");
                MyList<Artista> artistasCancion = new MyLinkedListImpl<>();
                for (String artista : nombreArtista) {
                    artistasCancion.add(new Artista(artista));
                }

                int posicion = Integer.parseInt(values[3].replace("\"", ""));
                String pais = values[6].replace("\"", "");
                LocalDate fecha = LocalDate.parse(values[7].replace("\"", ""));
                double tempo = Double.parseDouble(values[23].replace("\"", ""));

                Cancion cancion = new Cancion(nombreCancion, artistasCancion, tempo);
                EntradaTop50 entrada = new EntradaTop50(cancion, posicion, pais, fecha);
                entradas.add(entrada);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entradas;
    }
}
