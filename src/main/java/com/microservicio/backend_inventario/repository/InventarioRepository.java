package com.microservicio.backend_inventario.repository;

import com.microservicio.backend_inventario.model.InventarioDto;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InventarioRepository {

    private final List<InventarioDto> inventario = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    public InventarioRepository() {
        InventarioDto i1 = new InventarioDto();
        i1.setIdItem(idGenerator.incrementAndGet());
        i1.setNombre("Vacuna Antirrábica");
        i1.setDescripcion("Vacuna anual para perros y gatos");
        i1.setTipo("Vacuna");
        i1.setCantidadDisponible(50);
        i1.setUnidadMedida("dosis");
        i1.setEstado(1);
        inventario.add(i1);

        InventarioDto i2 = new InventarioDto();
        i2.setIdItem(idGenerator.incrementAndGet());
        i2.setNombre("Alimento para Gatos - Adultos");
        i2.setDescripcion("Bolsa de 10kg, marca NutriCat");
        i2.setTipo("Alimento");
        i2.setCantidadDisponible(20);
        i2.setUnidadMedida("kg");
        i2.setEstado(1);
        inventario.add(i2);

        InventarioDto i3 = new InventarioDto();
        i3.setIdItem(idGenerator.incrementAndGet());
        i3.setNombre("Guantes quirúrgicos");
        i3.setDescripcion("Guantes de látex, talla M");
        i3.setTipo("Insumo");
        i3.setCantidadDisponible(200);
        i3.setUnidadMedida("unidades");
        i3.setEstado(1);
        inventario.add(i3);

        InventarioDto i4 = new InventarioDto();
        i4.setIdItem(idGenerator.incrementAndGet());
        i4.setNombre("Antibiótico Amoxicilina 500mg");
        i4.setDescripcion("Caja con 20 cápsulas");
        i4.setTipo("Medicamento");
        i4.setCantidadDisponible(35);
        i4.setUnidadMedida("cajas");
        i4.setEstado(1);
        inventario.add(i4);

        InventarioDto i5 = new InventarioDto();
        i5.setIdItem(idGenerator.incrementAndGet());
        i5.setNombre("Shampoo Medicado");
        i5.setDescripcion("Botella de 250ml para tratamiento dérmico");
        i5.setTipo("Insumo");
        i5.setCantidadDisponible(15);
        i5.setUnidadMedida("ml");
        i5.setEstado(1);
        inventario.add(i5);
    }

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
