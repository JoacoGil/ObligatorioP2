package uy.edu.um;

import uy.edu.um.entities.CargaDatos;
import uy.edu.um.entities.DataStorage;
import uy.edu.um.entities.Menu;
import uy.edu.um.entities.EntradaTop50;
import uy.edu.um.tads.linkedlist.MyList;

public class Main {
    public static void main(String[] args) {
        // Instancia de DataStorage
        DataStorage dataStorage = new DataStorage();

        // Carga de datos
        CargaDatos cargaDatos = new CargaDatos();
        String csvFilePath = "C:\\Users\\Usuario\\Desktop\\UM\\P2\\Project\\ObligatorioP2\\src\\main\\java\\uy\\edu\\um\\reduced_data.csv"; // Ruta relativa al archivo CSV
        System.out.println("Intentando cargar el archivo desde: " + csvFilePath);
        MyList<EntradaTop50> entradas = cargaDatos.cargarDatosTop50(csvFilePath);

        // Agregar las entradas cargadas a DataStorage
        dataStorage.agregarEntradas(entradas);

        // Iniciar el menú
        Menu menu = new Menu(dataStorage);
        menu.iniciar();
    }
}
