package py.com.lincoln.todo_list_application.dtos;

import py.com.lincoln.todo_list_application.models.Tarea;
import py.com.lincoln.todo_list_application.models.Usuario;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Usuario}
 */
public record UsuarioDto(String nombreUsuario, List<Tarea> tareas) implements Serializable {
}