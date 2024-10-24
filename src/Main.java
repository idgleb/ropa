import gestInvent.GestionInventario;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {


        GestionInventario.inventario = new int[3][9];


        GestionInventario.ingresarInventarioInicial();

        int seleccion = 0;
        do {
            String[] opciones = {"Registrar una venta", "Mostrar inventario", "Salir"};
            seleccion = JOptionPane.showOptionDialog(
                    null,
                    "....",
                    "Ursol",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]
            );
            switch (seleccion) {
                case 0:
                    GestionInventario.registrarVenta();
                    break;
                case 1:
                    GestionInventario.mostrarInventario();
                    break;
                case 2:
                    break;
                default:
                    break;
            }
        } while (seleccion != 2);


    }
}





