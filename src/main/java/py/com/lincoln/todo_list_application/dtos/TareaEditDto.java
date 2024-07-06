package py.com.lincoln.todo_list_application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TareaEditDto {

    @NotBlank(message = "El titulo es requerido")
    private String titulo;

    private String descripcion;

    @NotNull(message = "El estado de la tarea es requerido")
    private Boolean completado;

    @NotNull(message = "El id del usuario es requerido")
    private Long usuarioId;

}
