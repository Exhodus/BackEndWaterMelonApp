Descripción
Proporciona una API REST para gestionar los recursos principales de la aplicación (usuarios, datos de dominio, etc.).
​

Está diseñado para integrarse con un frontend que consume estos endpoints y mantiene sincronización de datos (por ejemplo, usando WatermelonDB u otra base de datos local en cliente).
​

Requisitos previos
Java (versión indicada en el pom.xml del proyecto, normalmente 17 o superior en stacks modernos).
​

Maven para gestionar dependencias y tareas de compilación (mvn).
​

Una base de datos relacional (por ejemplo, PostgreSQL o MySQL) configurada con las credenciales que el backend espera en sus variables de entorno o application.properties.
​

Instalación y ejecución
Clonar el repositorio backend:

git clone https://github.com/Exhodus/BackEndWaterMelonApp.git.
​

Entrar en el directorio del proyecto:

cd BackEndWaterMelonApp.
​

Configurar las variables de entorno / propiedades:

URL de la base de datos (DB_URL o similar).

Usuario y contraseña de la base de datos.

Puerto del servidor HTTP (por ejemplo SERVER_PORT=8080).
​

Compilar y ejecutar:

mvn clean package para compilar.

mvn spring-boot:run o ejecutar el .jar generado en target/ para levantar el servidor.
​

Una vez arrancado, la API quedará disponible en http://localhost:8080 (o el puerto configurado).

Relación con el frontend
El backend está pensado para usarse junto al repositorio del frontend WaterMelonApp, que consume la API para mostrar y sincronizar datos al usuario.
​

El frontend debe configurarse para apuntar a la URL del backend (por ejemplo, variable API_BASE_URL=http://localhost:8080 en desarrollo y la URL del servidor en producción).
​

Si el frontend usa una base de datos local (como WatermelonDB) en modo offline-first, el backend actúa como origen de verdad remoto para sincronización periódica.
