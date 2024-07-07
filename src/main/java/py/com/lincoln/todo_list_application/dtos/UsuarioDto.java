package py.com.lincoln.todo_list_application.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import py.com.lincoln.todo_list_application.models.Usuario;

import java.io.Serializable;

/**
 * DTO for {@link Usuario}
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public record UsuarioDto(String nombreUsuario, String nombre, String apellido) implements Serializable {
}