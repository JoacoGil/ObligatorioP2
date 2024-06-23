package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyList;
import java.time.LocalDate;

public class quintaConsulta {
    private DataStorage dataStorage;

    public quintaConsulta(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    public void ejecutarConsulta(LocalDate fechaInicio, LocalDate fechaFin, double tempoMin, double tempoMax) {
        MyList<EntradaTop50> entradas = dataStorage.getEntradasPorRangoDeFechas(fechaInicio, fechaFin);
        if (entradas.size() == 0) {
            System.out.println("No se encontraron canciones para el rango de fechas especificado.");
            return;
        }

        int count = 0;
        for (int i = 0; i < entradas.size(); i++) {
            EntradaTop50 entrada = entradas.get(i);
            double tempo = entrada.getCancion().getTempo();
            if (tempo >= tempoMin && tempo <= tempoMax) {
                count++;
            }
        }

        System.out.println("Se encontraron " + count + " canciones con un tempo entre " + tempoMin + " y " + tempoMax + " en el rango de fechas " + fechaInicio + " a " + fechaFin + ".");
    }
}
