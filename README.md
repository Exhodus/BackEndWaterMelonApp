# BackEndWaterMelonApp

Este repositorio contiene el **backend** de la aplicación WaterMelonApp, pensado para trabajar junto al repositorio del frontend como API principal de negocio y acceso a datos.[conversation_history:1]

## Descripción

- Proporciona una API REST para gestionar los recursos principales de la aplicación (usuarios, datos de dominio, etc.).[conversation_history:1]  
- Está diseñado para integrarse con un frontend que consume estos endpoints y mantiene sincronización de datos mediante una base de datos local en cliente.[conversation_history:1]  

## Requisitos previos

- **Java** (versión indicada en el `pom.xml` del proyecto, normalmente 17 o superior).  
- **Maven** para gestionar dependencias y tareas de compilación (`mvn`).  
- Una base de datos relacional (por ejemplo, PostgreSQL o MySQL) configurada con las credenciales que el backend espera en sus variables de entorno o en `application.properties`.[conversation_history:1]  

## Instalación y ejecución

1. Clonar el repositorio backend:  
git clone https://github.com/Exhodus/BackEndWaterMelonApp.git

2. Entrar en el directorio del proyecto:  
cd BackEndWaterMelonApp

3. Configurar variables de entorno / propiedades (ejemplos):  
export DB_URL=jdbc:postgresql://localhost:5432/watermelon
export DB_USER=tu_usuario
export DB_PASSWORD=tu_password
export SERVER_PORT=8080

4. Compilar y ejecutar:  
mvn clean package
mvn spring-boot:run

O bien ejecutar el `.jar` generado en `target/`.  

Una vez arrancado, la API quedará disponible en `http://localhost:8080` (o el puerto configurado).[conversation_history:1]  

## Relación con el frontend

- Este backend está pensado para usarse junto al repositorio del **frontend WaterMelonApp**, que consume la API para mostrar y sincronizar datos al usuario.[conversation_history:1]  
- El frontend debe configurarse para apuntar a la URL del backend, por ejemplo:  
API_BASE_URL=http://localhost:8080

- En entornos de producción, el valor de `API_BASE_URL` debe cambiarse a la URL pública donde se despliegue el backend.[conversation_history:1]  

## Uso básico de la API

Los endpoints concretos dependen de la implementación, pero típicamente se incluyen rutas para:[conversation_history:1]  

- Autenticación y gestión de usuarios: registro, login, refresco de tokens.  
- Recursos de dominio de WaterMelonApp con operaciones CRUD (crear, leer, actualizar, eliminar).  
- Endpoints de sincronización para que el frontend envíe cambios locales y reciba actualizaciones del servidor cuando se use un modelo offline-first.[conversation_history:1]  

Para conocer el detalle de cada ruta, revisa los controladores del proyecto o la documentación de la API (por ejemplo, un `OpenAPI/Swagger` si estuviera disponible).
