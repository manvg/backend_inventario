package com.microservicio.backend_inventario.model;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class InventarioDto {

    private Long idItem;

    @NotBlank(message = "El nombre del ítem es obligatorio")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres")
    private String nombre;

    @Size(max = 255, message = "La descripción no puede tener más de 255 caracteres")
    private String descripcion;

    @NotBlank(message = "El tipo de ítem es obligatorio")
    @Size(max = 50, message = "El tipo no puede tener más de 50 caracteres")
    private String tipo;

    @NotNull(message = "La cantidad disponible es obligatoria")
    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private Integer cantidadDisponible;

    @Size(max = 20, message = "La unidad de medida no puede tener más de 20 caracteres")
    private String unidadMedida;

    @NotNull(message = "El estado es obligatorio")
    @Min(value = 0)
    @Max(value = 1)
    private Integer estado = 1;
}

