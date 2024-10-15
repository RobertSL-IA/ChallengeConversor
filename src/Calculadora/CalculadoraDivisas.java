package Calculadora;

import Modelos.ConversionTasa;
import Modelos.Tasas;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CalculadoraDivisas {
    private Gson gson;
    private HttpClient cliente;

    public CalculadoraDivisas() {
        gson = new GsonBuilder().setPrettyPrinting().create();
        cliente = HttpClient.newHttpClient();
    }

    public double convertir(String monedaOrigen, String monedaDestino, double cantidad) throws IOException, InterruptedException {
       
        monedaOrigen = monedaOrigen.replace(" ", "+");
        String direccion = "https://v6.exchangerate-api.com/v6/a0ab80efe14764ae85be660c/latest/" + monedaOrigen;

        HttpRequest solicitud = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> respuesta = cliente.send(solicitud, HttpResponse.BodyHandlers.ofString());

        String json = respuesta.body();
        
        System.out.println("Respuesta de la API: " + json);

        
        ConversionTasa tasaDeCambio = gson.fromJson(json, ConversionTasa.class);


       
        double tasa = obtenerTasaDeCambio(tasaDeCambio, monedaDestino);
        if (tasa == 0.0) {
            throw new IOException("Moneda de destino no soportada.");
        }

       
        return cantidad * tasa;
    }

    private double obtenerTasaDeCambio(ConversionTasa tasaDeCambio, String monedaDestino) {
        Tasas tasas = tasaDeCambio.getTasas_conversion(); 
        switch (monedaDestino) {
            case "ARS":
                return tasas.getARS();
            case "BRL":
                return tasas.getBRL();
            case "COP":
                return tasas.getCOP();
            case "USD":
                return tasas.getUSD();
            case "CLP":
                return tasas.getCLP();
            case "MXN":
                return tasas.getMXN();
            case "PEN":
                return tasas.getPEN();
            case "UYU":
                return tasas.getUYU(); 
            default:
                return 0.0; 
        }
    }
}


