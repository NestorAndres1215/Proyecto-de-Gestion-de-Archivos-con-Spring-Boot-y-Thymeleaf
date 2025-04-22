package com.example.demo.service;

import com.example.demo.entidad.Archivo;
import com.example.demo.repository.ArchivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ArchivoService {

    @Autowired
    private ArchivoRepository archivoRepository;

    public void guardarArchivo(MultipartFile archivo, String descripcion) throws IOException {
        Archivo archivoEntity = new Archivo();
        archivoEntity.setNombreArchivo(archivo.getOriginalFilename());
        archivoEntity.setTipoArchivo(archivo.getContentType());
        archivoEntity.setArchivo(archivo.getBytes());
        archivoEntity.setTamano(archivo.getSize());
        archivoEntity.setDescripcion(descripcion);
        archivoEntity.setFechaSubida(java.time.LocalDateTime.now().toString());

        archivoRepository.save(archivoEntity);
    }

    public Archivo obtenerArchivo(Long id) {
        return archivoRepository.findById(id).orElseThrow(() -> new RuntimeException("Archivo no encontrado"));
    }

    public List<Archivo> obtenerTodos() {
        return archivoRepository.findAll();
    }
}