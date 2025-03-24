package com.microservicio.backend_inventario.repository;

import com.microservicio.backend_inventario.model.InventarioDto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InventarioRepository {

    private final List<InventarioDto> inventario = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public List<InventarioDto> findAll() {
        return inventario;
    }

    public Optional<InventarioDto> findById(Long id) {
        return inventario.stream().filter(i -> i.getIdItem().equals(id)).findFirst();
    }

    public Optional<InventarioDto> findByNombre(String nombre) {
        return inventario.stream().filter(i -> i.getNombre().equalsIgnoreCase(nombre)).findFirst();
    }

    public InventarioDto save(InventarioDto item) {
        item.setIdItem(idGenerator.incrementAndGet());
        inventario.add(item);
        return item;
    }

    public boolean update(Long id, InventarioDto item) {
        for (int i = 0; i < inventario.size(); i++) {
            if (inventario.get(i).getIdItem().equals(id)) {
                item.setIdItem(id);
                inventario.set(i, item);
                return true;
            }
        }
        return false;
    }

    public boolean delete(Long id) {
        return inventario.removeIf(i -> i.getIdItem().equals(id));
    }
}
