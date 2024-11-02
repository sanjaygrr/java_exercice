
# 📡 HttpNotificationPlugin

¡Bienvenido a **HttpNotificationPlugin**! Este es un plugin en Java que permite realizar solicitudes HTTP a través de diferentes métodos (POST, GET, PUT, DELETE). Ideal para integraciones sencillas y rápidas con APIs RESTful.

---

## 📋 Contexto

El **HttpNotificationPlugin** fue diseñado para simplificar el envío de notificaciones HTTP en aplicaciones de automatización y scripts. Permite personalizar la solicitud HTTP con el método, encabezado `Content-Type`, cuerpo del mensaje y URL de destino.

---

## ⚙️ Instalación

### 1. Clona el repositorio:

```bash
git clone https://github.com/tu_usuario/HttpNotificationPlugin.git
cd HttpNotificationPlugin
```

### 2. Construye el proyecto:

Usando Maven, limpia y empaqueta el proyecto:

```bash
mvn clean package
```

Esto generará un archivo `.jar` en la carpeta `target`.

---

## 🚀 Uso

### Ejecución del `.jar` con parámetros

Puedes ejecutar el `.jar` con el siguiente comando:

```bash
java -jar target/HttpNotificationPlugin-1.0.jar <HTTP_METHOD> <CONTENT_TYPE> <REQUEST_BODY> <URL>
```

- **HTTP_METHOD**: Método HTTP (`POST`, `GET`, `PUT`, `DELETE`).
- **CONTENT_TYPE**: Tipo de contenido (e.g., `application/json`).
- **REQUEST_BODY**: El cuerpo de la solicitud en formato JSON.
- **URL**: La URL de la API de destino.

---

## 🔧 Ejemplos

1. **Realizar una solicitud POST:**

```bash
java -jar target/HttpNotificationPlugin-1.0.jar POST "application/json" "{"title":"foo","body":"bar","userId":1}" "https://jsonplaceholder.typicode.com/posts"
```

**Resultado esperado:**
```
Response Code: 201
```

2. **Realizar una solicitud GET:**

```bash
java -jar target/HttpNotificationPlugin-1.0.jar GET "application/json" "" "https://jsonplaceholder.typicode.com/posts/1"
```

**Resultado esperado:**
```
Response Code: 200
```

3. **Realizar una solicitud PUT:**

```bash
java -jar target/HttpNotificationPlugin-1.0.jar PUT "application/json" "{"title":"updated title","body":"updated body","userId":1}" "https://jsonplaceholder.typicode.com/posts/1"
```

**Resultado esperado:**
```
Response Code: 200
```

4. **Realizar una solicitud DELETE:**

```bash
java -jar target/HttpNotificationPlugin-1.0.jar DELETE "application/json" "" "https://jsonplaceholder.typicode.com/posts/1"
```

**Resultado esperado:**
```
Response Code: 200
```

---

## 📄 Resultados y Funcionalidades

Cada ejecución del plugin imprime el código de respuesta HTTP en la consola. Esto permite verificar rápidamente el éxito o fallo de la solicitud enviada. Para pruebas, se recomienda usar [JSONPlaceholder](https://jsonplaceholder.typicode.com/) u otros servicios de prueba de API.

---

## 🚧 Notas

- **Compatibilidad**: Requiere Java 11+ y Maven.
- **Errores comunes**:
  - Código 405: Método HTTP no permitido en la URL.
  - Código 404: URL no encontrada.
  - Código 500: Error del servidor.

---

## 🎉 Contribución

¡Siempre se agradecen contribuciones para mejorar este plugin! Si deseas agregar más funcionalidades o mejorar la documentación, no dudes en hacer un fork y un pull request.

---

**¡Gracias por utilizar HttpNotificationPlugin!** 🎈