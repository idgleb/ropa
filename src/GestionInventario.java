import javax.swing.JOptionPane;

public class GestionInventario {


    static int[][] inventario;
    static String[] ropa = {"Camisetas", "Pantalones", "Chaquetas"};
    static String[] tallasColores = {
            "S-rojo", "S-azul", "S-verde",
            "M-rojo", "M-azul", "M-verde",
            "L-rojo", "L-azul", "L-verde"
    };


    public static void ingresarInventarioInicial() {
        JOptionPane.showMessageDialog(null, " inventario inicial?:");
        for (int i = 0; i < inventario.length; i++) {
            JOptionPane.showMessageDialog(null, ropa[i] + ":");
            for (int j = 0; j < inventario[i].length; j++) {
                String cantidadStr;
                int cantidad;
                do {
                    cantidadStr = JOptionPane.showInputDialog(null, tallasColores[j] + ":");
                    cantidad = validarNumeroPositivo(cantidadStr);
                    if (cantidad == -1) {
                        JOptionPane.showMessageDialog(null, "no valida.  ingrese un numero entero positivo.");
                    }
                } while (cantidad == -1);
                inventario[i][j] = cantidad;
            }
        }
    }


    public static int validarNumeroPositivo(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return -1;
            }
        }
        int numero = Integer.parseInt(input);
        if (numero >= 0) {
            return numero;
        } else {
            return -1;
        }
    }


    public static void registrarVenta() {
        JOptionPane.showMessageDialog(null, "Registrar venta:");


        String tipoPrendaStr;
        int tipoPrenda;
        do {
            tipoPrendaStr = JOptionPane.showInputDialog(null, "Seleccione tipo de prenda:\n" +
                    "1. Camisetas\n" +
                    "2. Pantalones\n" +
                    "3. Chaquetas"
            );
            tipoPrenda = validarRango(tipoPrendaStr, 1, ropa.length);
            if (tipoPrenda == -1) {
                JOptionPane.showMessageDialog(null, " no valida.  ingrese un numero .");
            }
        } while (tipoPrenda == -1);
        tipoPrenda--;


        String tallaColorStr;
        int tallaColor;
        do {
            tallaColorStr = JOptionPane.showInputDialog(null, "Seleccione  talla y  color:\n" +
                    "1. S-rojo\n" +
                    "2. S-azul\n" +
                    "3. S-verde\n" +
                    "4. M-rojo\n" +
                    "5. M-azul\n" +
                    "6. M-verde\n" +
                    "7. L-rojo\n" +
                    "8. L-azul\n" +
                    "9. L-verde"
            );
            tallaColor = validarRango(tallaColorStr, 1, tallasColores.length);
            if (tallaColor == -1) {
                JOptionPane.showMessageDialog(null, " no valida. Por favor, ingrese  numero .");
            }
        } while (tallaColor == -1);
        tallaColor--;

        String cantidadVendidaStr;
        int cantidadVendida;
        do {
            cantidadVendidaStr = JOptionPane.showInputDialog(null, "Ingrese cantidad vendida:");
            cantidadVendida = validarNumeroPositivo(cantidadVendidaStr);
            if (cantidadVendida == -1) {
                JOptionPane.showMessageDialog(null, " no valida.  ingrese un numero entero positivo.");
            }
        } while (cantidadVendida == -1);


        if (actualizarInventario(tipoPrenda, tallaColor, cantidadVendida)) {
            JOptionPane.showMessageDialog(null, "Venta registrada.");
        } else {
            JOptionPane.showMessageDialog(null, " No hay suficiente.");
        }
    }


    public static int validarRango(String input, int min, int max) {
        if (input.length() == 0 || !Character.isDigit(input.charAt(0))) {
            return -1;
        }
        int valor = Integer.parseInt(input);
        if (valor >= min && valor <= max) {
            return valor;
        } else {
            return -1;
        }
    }


    public static boolean actualizarInventario(int tipoPrenda, int tallaColor, int cantidadVendida) {
        if (inventario[tipoPrenda][tallaColor] >= cantidadVendida) {
            inventario[tipoPrenda][tallaColor] -= cantidadVendida;
            return true;
        }
        return false;
    }


    public static void mostrarInventario() {
        StringBuilder reporte = new StringBuilder();
        reporte.append("\nInventario :\n");
        for (int i = 0; i < inventario.length; i++) {
            reporte.append(ropa[i]).append(":\n");
            for (int j = 0; j < inventario[i].length; j++) {
                reporte.append(tallasColores[j]).append(": ").append(inventario[i][j]).append(" unidades restantes.\n");
            }
            reporte.append("\n");
        }
        JOptionPane.showMessageDialog(null, reporte.toString());
    }
}
