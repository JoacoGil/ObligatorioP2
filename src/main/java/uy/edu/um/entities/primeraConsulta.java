package uy.edu.um.entities;

import uy.edu.um.tads.linkedlist.MyList;

import java.util.Scanner;
import java.time.LocalDate;

public class primeraConsulta {
    Scanner scanner = new Scanner(System.in);

    LocalDate fecha;
    String pais;

    private void primeraConsultaMenu() {
        System.out.println("Ingrese el pais:");
        pais = scanner.nextLine();
        System.out.println("Ingrese la fecha en formato YYYY-MM-DD");
        fecha = LocalDate.parse(scanner.nextLine());


    }

    private static void printTop10Songs(MyList<EntradaTop50> top10Songs) {
        System.out.println("Top 10 canciones:");
        for (int i = 0; i < top10Songs.size(); i++) {
            EntradaTop50 entry = top10Songs.get(i);
            System.out.println((i + 1) + ". " + entry.getCancion().getNombre() + " - " + entry.getCancion().getArtistas().get(0).getNombre() +
                    " (Posición: " + entry.getPosicion() + ")");
        }
    }
}
