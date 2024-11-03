package com.example.rundeckplugin;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class HttpNotificationPluginTest {

    @Test
    public void testPostRequest() throws IOException {
        HttpNotificationPlugin plugin = new HttpNotificationPlugin("POST", "application/json", "{\"key\":\"value\"}",
                "http://example.com");
        plugin.sendNotification();
    }

    @Test
    public void testGetRequest() throws IOException {
        HttpNotificationPlugin plugin = new HttpNotificationPlugin("GET", "application/json", null,
                "http://example.com");
        plugin.sendNotification();
    }

    @Test
    public void testPutRequest() throws IOException {
        HttpNotificationPlugin plugin = new HttpNotificationPlugin("PUT", "application/json", "{\"key\":\"updated\"}",
                "http://example.com");
        plugin.sendNotification();
    }

    @Test
    public void testDeleteRequest() throws IOException {
        HttpNotificationPlugin plugin = new HttpNotificationPlugin("DELETE", "application/json", null,
                "http://example.com");
        plugin.sendNotification();
    }

    @Test
    public void testUnsupportedMethod() {
        Exception exception = assertThrows(UnsupportedOperationException.class, () -> {
            HttpNotificationPlugin plugin = new HttpNotificationPlugin("PATCH", "application/json", null,
                    "http://example.com");
            plugin.sendNotification();
        });
        assertEquals("Método HTTP no soportado: PATCH", exception.getMessage());
    }
}
