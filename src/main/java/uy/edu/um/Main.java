package uy.edu.um;
import uy.edu.um.entities.EntradaTop50;
import uy.edu.um.tads.linkedlist.MyList;
import uy.edu.um.entities.CargaDatos;
import uy.edu.um.entities.Menu;

public class Main {
    public static void main(String[] args) {
        CargaDatos cargaDatos = new CargaDatos();
        MyList<EntradaTop50> entradasTop50 = cargaDatos.cargarDatosTop50("C:\\Users\\juanf\\IdeaProjects\\ObligatorioP2\\src\\main\\java\\uy\\edu\\um\\reduced_data.csv");
        //Menu.Menu();
    }
}