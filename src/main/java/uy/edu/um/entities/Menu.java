package uy.edu.um.entities;
import uy.edu.um.tads.linkedlist.MyList;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    public static void Menu(){
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Bienvenido, seleccione una de las siguienes opciones!");

        int op1;

        do{
            System.out.println("1 - Top 10 canciones en un pais en un día dado");
            System.out.println("2 - Top 5 canciones que aparecen en más top 50 en un día dado");
            System.out.println("3 - Top 7 artistas que más aparecen en los tops 50 para un rango de fechas dado");
            System.out.println("4 - Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
            System.out.println("5 - Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas.");
            System.out.println("6 - SALIR");

            op1=Integer.parseInt(scanner.nextLine());

            LocalDate fecha;
            String pais;
            String artista;
            LocalDate fechaInicio;
            LocalDate fechaFin;


            switch (op1){
                case 1:
                    System.out.println("Top 10 canciones en un pais en un día dado");
                    System.out.println("Ingrese país");
                    pais = scanner.nextLine();
                    System.out.println("Ingrese una fecha en formato YYYY-MM-DD");
                    fecha = LocalDate.parse(scanner.nextLine());
                    DataStorage dataStorage = new DataStorage();
                    MyList<EntradaTop50> top10Songs = dataStorage.getTop10Songs(pais, fecha);
                    printTop10Songs(top10Songs);
                    break;
                case 2:
                    System.out.println("Top 5 canciones que aparecen en más top 50 en un día dado");
                    System.out.println("Ingresa una fecha en formato YYYY-MM-DD");
                    fecha = LocalDate.parse(scanner.nextLine());
                    // Agregar llamado a funcion correspondiente
                case 3:
                    System.out.println("Top 7 artistas que más aparecen en los tops 50 para un rango de fechas dado");
                    System.out.println("Ingresa una fecha de inicio en formato YYYY-MM-DD");
                    fechaInicio = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa una fecha de fin en formato YYYY-MM-DD");
                    fechaFin = LocalDate.parse(scanner.nextLine());
                    // Agregar llamado a funcion correspondiente
                case 4:
                    System.out.println("Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
                    System.out.println("Ingresa una fecha en formato YYYY-MM-DD");
                    fecha = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa un artista");
                    artista = scanner.nextLine();
                    // Agregar llamado a funcion correspondiente
                case 5:
                    System.out.println("Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas.");
                    System.out.println("Ingresa una fecha de inicio en formato YYYY-MM-DD");
                    fechaInicio = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa una fecha de fin en formato YYYY-MM-DD");
                    fechaFin = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa un tempo mínimo");
                    int tempoMin = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingresa un tempo máximo");
                    int tempoMax = Integer.parseInt(scanner.nextLine());
                    // Agregar llamado a funcion correspondiente
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (op1!=6);
    }

    private static void printTop10Songs(MyList<EntradaTop50> top10Songs) {
        System.out.println("Top 10 canciones:");
        for (int i = 0; i < top10Songs.size(); i++) {
            EntradaTop50 entry = top10Songs.get(i);
            System.out.println((i + 1) + ". " + entry.getCancion().getNombre() + " - " + entry.getCancion().getArtists().get(0).getNombre() +
                    " (Posición: " + entry.getPosicion() + ")");
        }
    }


}
