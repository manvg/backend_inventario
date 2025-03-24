package com.microservicio.backend_inventario.service;

import com.microservicio.backend_inventario.model.InventarioDto;

import java.util.List;
import java.util.Optional;

public interface InventarioService {
    List<InventarioDto> getAll();
    Optional<InventarioDto> getById(Long id);
    InventarioDto create(InventarioDto item);
    Optional<InventarioDto> update(Long id, InventarioDto item);
    boolean delete(Long id);
}