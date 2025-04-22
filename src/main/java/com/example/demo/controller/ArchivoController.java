package com.example.demo.controller;

import com.example.demo.entidad.Archivo;
import com.example.demo.service.ArchivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/archivos")
public class ArchivoController {

    @Autowired
    private ArchivoService archivoService;

    // Página principal con enlaces
    @GetMapping("/")
    public String verPaginaPrincipal() {
        return "index";  // Redirige a la página principal con las opciones
    }

    // Listado de archivos
    @GetMapping("/listado")
    public String verListado(Model model) {
        List<Archivo> archivos = archivoService.obtenerTodos();
        model.addAttribute("archivos", archivos);
        return "listado";  // Vista para listar los archivos
    }

    // Formulario para registrar un archivo
    @GetMapping("/registrar")
    public String registrarArchivo() {
        return "registrar";  // Vista para el formulario de registro de archivos
    }

    // Subir un archivo
    @PostMapping("/subir")
    public String subirArchivo(@RequestParam("archivo") MultipartFile archivo,
                               @RequestParam("descripcion") String descripcion) {
        try {
            archivoService.guardarArchivo(archivo, descripcion);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/archivos/listado";  // Redirige a la página de listado después de subir el archivo
    }

    // Descargar archivo
    @GetMapping("/descargar/{id}")
    public ResponseEntity<ByteArrayResource> descargarArchivo(@PathVariable Long id) {
        Archivo archivo = archivoService.obtenerArchivo(id);

        // Devuelve el archivo con los encabezados HTTP correctos para que se descargue
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + archivo.getNombreArchivo() + "\"")
                .header(HttpHeaders.CONTENT_TYPE, archivo.getTipoArchivo())
                .body(new ByteArrayResource(archivo.getArchivo()));
    }
}
