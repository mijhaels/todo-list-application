package py.com.lincoln.todo_list_application.dtos;

import py.com.lincoln.todo_list_application.models.Tarea;
import py.com.lincoln.todo_list_application.models.Usuario;

import java.io.Serializable;

/**
 * DTO for {@link Tarea}
 */
public record TareaDto(String titulo, String descripcion, Boolean completado, Usuario usuario) implements Serializable {
}