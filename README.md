# Sistema de Gestión de Ventas de Calzado

![image](https://github.com/user-attachments/assets/06c37a34-cfd2-41e8-89d4-81c6a9dc42ee)

<div align="center">

![Java](https://img.shields.io/badge/Java%2017-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/Spring%20Boot%203-6DB33F?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-000000?style=for-the-badge&logo=json-web-tokens&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)

</div>

## Descripción
Sistema backend desarrollado en Spring Boot para la gestión de ventas de calzado. Permite administrar inventario, ventas, usuarios y autenticación mediante tokens JWT.

## 🛠️ Tecnologías Utilizadas
- Java 17
- Spring Boot 3
- Spring Security + JWT
- Maven
- PostgreSQL
- Swagger/OpenAPI

## ⚡ Características Principales
- Gestión de usuarios con roles (ADMIN/USER)
- Control de inventario de calzado
- Registro y seguimiento de ventas
- Gestión de clientes
- API REST documentada con Swagger
- Autenticación y autorización con JWT

## 🔑 Endpoints Principales

### Autenticación
- POST `/api/v1/autenticacion/signupuser` - Registro de usuarios
- POST `/api/v1/autenticacion/signupadmin` - Registro de administradores
- POST `/api/v1/autenticacion/signin` - Inicio de sesión

### Documentación API
- Swagger UI: `http://localhost:8080/swagger-ui.html`
- OpenAPI JSON: `http://localhost:8080/v3/api-docs`

## 📦 Estructura del Proyecto

```plaintext
📦 msventaspro
 ┣ 📂 config
 ┃ ┣ 📜 JwtAuthenticationFilter
 ┃ ┣ 📜 SecurityConfig
 ┃ ┗ 📜 SwaggerConfig
 ┣ 📂 controller
 ┃ ┣ 📂 advice
 ┃ ┣ 📜 AutenticacionController
 ┃ ┣ 📜 VentaController
 ┃ ┗ 📜 CalzadoController
 ┃ ┗ 📜 ....
 ┣ 📂 Repository
 ┃ ┗ 📜 interfaces
 ┣ 📂 entity
 ┃ ┣ 📜 Calzado
 ┃ ┣ 📜 Categoria
 ┃ ┣ 📜 Cliente
 ┃ ┣ 📜 DetalleVenta
 ┃ ┣ 📜 Promocion
 ┃ ┣ 📜 Rol
 ┃ ┣ 📜 Venta
 ┃ ┗ 📜 Usuario
 ┣ 📂 service
   ┣ 📂 impl
   ┗ 📜 interfaces

## 💻 Instalación y Uso

1. Clonar el repositorio
2. Configurar base de datos PostgreSQL
3. Actualizar `application.properties` con credenciales de BD
4. Ejecutar: `mvn spring-boot:run`
5. Acceder a Swagger: `http://localhost:8080/swagger-ui.html`

## ✒️ Autor
Jhonatan Ponce Policio - [link](https://www.linkedin.com/in/jhonatan-adrian-ponce-policio/)

