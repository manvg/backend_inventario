package com.microservicio.backend_inventario.service;

import com.microservicio.backend_inventario.model.InventarioDto;
import com.microservicio.backend_inventario.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository repository;

    @Override
    public List<InventarioDto> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<InventarioDto> getById(Long id) {
        return repository.findById(id);
    }

    @Override
    public InventarioDto create(InventarioDto item) {
        return repository.save(item);
    }

    @Override
    public Optional<InventarioDto> update(Long id, InventarioDto item) {
        boolean updated = repository.update(id, item);
        return updated ? Optional.of(item) : Optional.empty();
    }

    @Override
    public boolean delete(Long id) {
        return repository.delete(id);
    }
}