package com.example.rundeckplugin;

import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.HttpResponse;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class HttpNotificationPlugin {

    private String httpMethod;
    private String contentType;
    private String requestBody;
    private String url;

    // Constructor para inicializar los valores de la solicitud
    public HttpNotificationPlugin(String httpMethod, String contentType, String requestBody, String url) {
        this.httpMethod = httpMethod;
        this.contentType = contentType;
        this.requestBody = requestBody;
        this.url = url;
    }

    // Método principal para enviar la solicitud HTTP
    public void sendNotification() throws IOException {
        // Crear el cliente HTTP
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpRequestBase request = createHttpRequest();

            // Configurar el encabezado de tipo de contenido
            request.setHeader("Content-Type", contentType);

            // Ejecutar la solicitud y obtener la respuesta
            HttpResponse response = client.execute(request);
            System.out.println("Response Code: " + response.getStatusLine().getStatusCode());
        }
    }

    // Método para crear la solicitud HTTP según el método especificado
    private HttpRequestBase createHttpRequest() throws UnsupportedEncodingException {
        switch (httpMethod.toUpperCase()) {
            case "POST":
                HttpPost postRequest = new HttpPost(url);
                postRequest.setEntity(new StringEntity(requestBody, "UTF-8"));
                return postRequest;
            case "PUT":
                HttpPut putRequest = new HttpPut(url);
                putRequest.setEntity(new StringEntity(requestBody, "UTF-8"));
                return putRequest;
            case "GET":
                return new HttpGet(url);
            case "DELETE":
                return new HttpDelete(url);
            default:
                throw new UnsupportedOperationException("Método HTTP no soportado: " + httpMethod);
        }
    }

    // Método main para iniciar el JAR ejecutable
    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println(
                    "Uso: java -jar HttpNotificationPlugin.jar <httpMethod> <contentType> <requestBody> <url>");
            return;
        }

        String httpMethod = args[0];
        String contentType = args[1];
        String requestBody = args[2];
        String url = args[3];

        HttpNotificationPlugin plugin = new HttpNotificationPlugin(httpMethod, contentType, requestBody, url);
        try {
            plugin.sendNotification();
        } catch (IOException e) {
            System.err.println("Error al enviar la notificación: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
