package uy.edu.um.entities;

import java.time.LocalDate;
import java.util.Scanner;

public class Menu {
    private DataStorage dataStorage;
    private Scanner scanner;

    public Menu(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        System.out.println("Bienvenido, seleccione una de las siguientes opciones!");

        int op1;

        do {
            System.out.println("1 - Top 10 canciones en un pais en un día dado");
            System.out.println("2 - Top 5 canciones que aparecen en más top 50 en un día dado");
            System.out.println("3 - Top 7 artistas que más aparecen en los tops 50 para un rango de fechas dado");
            System.out.println("4 - Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
            System.out.println("5 - Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas.");
            System.out.println("6 - SALIR");

            op1 = Integer.parseInt(scanner.nextLine());

            LocalDate fecha;
            String pais;
            String artista;
            LocalDate fechaInicio;
            LocalDate fechaFin;

            switch (op1) {
                case 1:
                    System.out.println("Top 10 canciones en un pais en un día dado");
                    System.out.println("Ingrese país (código del país, por ejemplo 'NI')");
                    pais = scanner.nextLine();
                    System.out.println("Ingrese una fecha en formato YYYY-MM-DD");
                    fecha = LocalDate.parse(scanner.nextLine());
                    primeraConsulta primeraConsulta = new primeraConsulta(dataStorage);
                    primeraConsulta.ejecutarConsulta(pais, fecha);
                    break;
                case 2:
                    System.out.println("Top 5 canciones que aparecen en más top 50 en un día dado");
                    System.out.println("Ingresa una fecha en formato YYYY-MM-DD");
                    fecha = LocalDate.parse(scanner.nextLine());
                    segundaConsulta segundaConsulta = new segundaConsulta(dataStorage);
                    segundaConsulta.ejecutarConsulta(fecha);
                    break;
                case 3:
                    System.out.println("Top 7 artistas que más aparecen en los tops 50 para un rango de fechas dado");
                    System.out.println("Ingresa una fecha de inicio en formato YYYY-MM-DD");
                    fechaInicio = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa una fecha de fin en formato YYYY-MM-DD");
                    fechaFin = LocalDate.parse(scanner.nextLine());
                    terceraConsulta terceraConsulta = new terceraConsulta(dataStorage);
                    terceraConsulta.ejecutarConsulta(fechaInicio, fechaFin);
                    break;
                case 4:
                    System.out.println("Cantidad de veces que aparece un artista específico en un top 50 en una fecha dada");
                    System.out.println("Ingresa una fecha en formato YYYY-MM-DD");
                    fecha = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa un artista");
                    artista = scanner.nextLine();
                    cuartaConsulta cuartaConsulta = new cuartaConsulta(dataStorage);
                    cuartaConsulta.ejecutarConsulta(artista, fecha);
                    break;
                case 5:
                    System.out.println("Cantidad de canciones con un tempo en un rango específico para un rango específico de fechas.");
                    System.out.println("Ingresa una fecha de inicio en formato YYYY-MM-DD");
                    fechaInicio = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa una fecha de fin en formato YYYY-MM-DD");
                    fechaFin = LocalDate.parse(scanner.nextLine());
                    System.out.println("Ingresa un tempo mínimo");
                    double tempoMin = Double.parseDouble(scanner.nextLine());
                    System.out.println("Ingresa un tempo máximo");
                    double tempoMax = Double.parseDouble(scanner.nextLine());
                    quintaConsulta quintaConsulta = new quintaConsulta(dataStorage);
                    quintaConsulta.ejecutarConsulta(fechaInicio, fechaFin, tempoMin, tempoMax);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        } while (op1 != 6);
    }
}
