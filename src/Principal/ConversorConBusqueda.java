package Principal;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import Calculadora.CalculadoraDivisas;
import Modelos.Conversion;
import Modelos.HistorialConversiones;

public class ConversorConBusqueda {
    public static void mostrarMenu() {
        System.out.println("**************************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda :)");
        System.out.println("**************************************************");
        System.out.println("1) Dólar => Peso argentino");
        System.out.println("2) Peso argentino => Dólar");
        System.out.println("3) Dólar => Real brasileño");
        System.out.println("4) Real brasileño => Dólar");
        System.out.println("5) Dólar => Peso colombiano");
        System.out.println("6) Peso colombiano => Dólar");
        System.out.println("7) Dólar => Peso chileno");
        System.out.println("8) Peso chileno => Dólar");
        System.out.println("9) Dólar => Peso mexicano");
        System.out.println("10) Peso mexicano => Dólar");
        System.out.println("11) Dólar => Sol peruano");
        System.out.println("12) Sol peruano => Dólar");
        System.out.println("13) Dólar => Peso uruguayo");
        System.out.println("14) Peso uruguayo => Dólar");
        System.out.println("15) Mostrar historial de conversiones");
        System.out.println("16) Salir");
        System.out.println("**************************************************");
        System.out.print("Elija una opción válida: ");
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        HistorialConversiones historial = new HistorialConversiones();
        CalculadoraDivisas calculadora = new CalculadoraDivisas();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();  

            String monedaOrigen = "";
            String monedaDestino = "";
            switch (opcion) {
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    break;
                case 3:
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    break;
                case 4:
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    break;
                case 5:
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    break;
                case 6:
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    break;
                case 7:
                    monedaOrigen = "USD";
                    monedaDestino = "CLP";
                    break;
                case 8:
                    monedaOrigen = "CLP";
                    monedaDestino = "USD";
                    break;
                case 9:
                    monedaOrigen = "USD";
                    monedaDestino = "MXN";
                    break;
                case 10:
                    monedaOrigen = "MXN";
                    monedaDestino = "USD";
                    break;
                case 11:
                    monedaOrigen = "USD";
                    monedaDestino = "PEN";
                    break;
                case 12:
                    monedaOrigen = "PEN";
                    monedaDestino = "USD";
                    break;
                case 13:
                    monedaOrigen = "USD";
                    monedaDestino = "UYU";
                    break;
                case 14:
                    monedaOrigen = "UYU";
                    monedaDestino = "USD";
                    break;
                case 15:
                    historial.mostrarHistorial();
                    continue;
                case 16:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
                    continue;
            }

            if (opcion >= 1 && opcion <= 14) {
                System.out.println("Escriba la cantidad a convertir: ");
                double cantidad = scanner.nextDouble();
                scanner.nextLine();  

                if (cantidad < 0) {
                    System.out.println("La cantidad debe ser un número positivo.");
                    continue;
                }

                try {
                   
                    double resultado = calculadora.convertir(monedaOrigen, monedaDestino, cantidad);
                    System.out.printf("Resultado de la conversión: %.2f %s%n", resultado, monedaDestino);

                    
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String fecha = LocalDateTime.now().format(formatter);

                    
                    Conversion conversión = new Conversion(monedaOrigen, monedaDestino, cantidad, resultado, fecha);
                    historial.agregarConversion(conversión);

                } catch (Exception e) {
                    System.out.println("Ocurrió un error durante la conversión: " + e.getMessage());
                }
            }

        } while (opcion != 16);

        scanner.close();
    }
}



