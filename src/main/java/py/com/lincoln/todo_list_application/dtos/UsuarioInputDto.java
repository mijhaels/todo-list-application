package py.com.lincoln.todo_list_application.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import py.com.lincoln.todo_list_application.enums.UsuarioRoles;

@Getter
@Setter
public class UsuarioInputDto {

    @NotBlank(message = "El nombre de usuario es requerido")
    private String nombreUsuario;

    @NotBlank(message = "La contraseña es requerida")
    private String password;

    @NotNull(message = "El rol es requerido")
    private UsuarioRoles rol;

    private String nombre;

    private String apellido;
}
