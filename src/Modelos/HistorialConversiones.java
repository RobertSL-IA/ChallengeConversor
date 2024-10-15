package Modelos;

import java.util.ArrayList;
import java.util.List;

public class HistorialConversiones {
    private List<Conversion> conversiones;

    public HistorialConversiones() {
        this.conversiones = new ArrayList<>();
    }

    public void agregarConversion(Conversion conversion) {
        conversiones.add(conversion);
    }

    public void mostrarHistorial() {
        System.out.println("Historial de Conversiones:");
        for (Conversion conversion : conversiones) {
            System.out.printf("De: %s a %s | Cantidad: %.2f | Resultado: %.2f | Tasa: %.4f | Fecha: %s%n",
                    conversion.getMonedaOrigen(),
                    conversion.getMonedaDestino(),
                    conversion.getCantidad(),
                    conversion.getResultado(),
                    conversion.getTasa(),
                    conversion.getFecha());
        }
    }
}

