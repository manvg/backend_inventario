package com.microservicio.backend_inventario.controller;

import com.microservicio.backend_inventario.model.InventarioDto;
import com.microservicio.backend_inventario.service.InventarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @GetMapping
    public List<InventarioDto> getAll() {
        return inventarioService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        return inventarioService.getById(id)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ítem no encontrado"));
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid InventarioDto item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventarioService.create(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody @Valid InventarioDto item) {
        return inventarioService.update(id, item)
                .<ResponseEntity<?>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ítem no encontrado"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        boolean deleted = inventarioService.delete(id);
        if (deleted) {
            return ResponseEntity.ok("Ítem eliminado correctamente");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Ítem no encontrado");
        }
    }
}