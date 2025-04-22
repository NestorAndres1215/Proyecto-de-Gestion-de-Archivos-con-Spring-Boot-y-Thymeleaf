# Proyecto de Gestión de Archivos con Spring Boot y Thymeleaf

## Descripción

Este proyecto es un sistema simple de gestión de archivos utilizando **Spring Boot** y **Thymeleaf**. El sistema permite a los usuarios:

1. Subir archivos (PDF, Excel, Word, etc.) a la aplicación.
2. Ver un listado de los archivos subidos.
3. Descargar los archivos almacenados.
4. Almacenar los archivos en la base de datos MySQL como blobs.

### Funcionalidades:
- **Página Principal**: Presenta opciones para ver el listado de archivos o registrar nuevos archivos.
- **Registrar Archivos**: Los usuarios pueden subir archivos junto con una descripción.
- **Listado de Archivos**: Muestra todos los archivos registrados y proporciona enlaces para descargarlos.

## Dependencias

A continuación, se listan las dependencias necesarias para que el proyecto funcione correctamente.

### `pom.xml` (si usas Maven)

```xml
<dependencies>
    <!-- Spring Boot Web para crear una aplicación web con Spring Boot -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <!-- Spring Boot Thymeleaf para usar Thymeleaf como motor de plantillas -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-thymeleaf</artifactId>
    </dependency>

    <!-- Spring Boot Data JPA para interacción con la base de datos -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>

    <!-- MySQL Connector para conectar con la base de datos MySQL -->
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
    </dependency>

    <!-- Spring Boot Starter Test para pruebas unitarias -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
