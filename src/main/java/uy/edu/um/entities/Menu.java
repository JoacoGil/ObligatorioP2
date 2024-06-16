package uy.edu.um.entities;
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

            String fecha;
            String pais;
            String artista;
            String fechaInicio;
            String fechaFin;


            switch (op1){
                case 1:
                    System.out.println("Top 10 canciones en un pais en un día dado");
                    System.out.println("Ingrese país");
                    pais = scanner.nextLine();
                    System.out.println("Ingrese una fecha en formato YYYY-MM-DD");
                    fecha = scanner.nextLine();
                    // Agregar llamado a funcion correspondiente
                case 2:
                    System.out.println("Top 5 canciones que aparecen en más top 50 en un día dado");
                    System.out.println("Ingresa una fecha en formato YYYY-MM-DD");
                    fecha = scanner.nextLine();
                    // Agregar llamado a funcion correspondiente
                case 3:
                    System.out.println("Top 7 artistas que más aparecen en los tops 50 para un rango de fechas dado");
                    System.out.println("Ingresa una fecha de inicio en formato YYYY-MM-DD");
                    fechaInicio = scanner.nextLine();
                    System.out.println("Ingresa una fecha de fin en formato YYYY-MM-DD");
                    fechaFin = scanner.nextLine();
                    // Agregar llamado a funcion correspondiente
                case 4:
                    System.out.println("Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
                    System.out.println("Ingresa una fecha en formato YYYY-MM-DD");
                    fecha = scanner.nextLine();
                    System.out.println("Ingresa un artista");
                    artista = scanner.nextLine();
                    // Agregar llamado a funcion correspondiente
                case 5:
                    System.out.println("Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas.");
                    System.out.println("Ingresa una fecha de inicio en formato YYYY-MM-DD");
                    fechaInicio = scanner.nextLine();
                    System.out.println("Ingresa una fecha de fin en formato YYYY-MM-DD");
                    fechaFin = scanner.nextLine();
                    System.out.println("Ingresa un tempo mínimo");
                    int tempoMin = Integer.parseInt(scanner.nextLine());
                    System.out.println("Ingresa un tempo máximo");
                    int tempoMax = Integer.parseInt(scanner.nextLine());
                    // Agregar llamado a funcion correspondiente
                default:
                    System.out.println("Opción inválida");
            }
        } while (op1!=6);
    }


}
