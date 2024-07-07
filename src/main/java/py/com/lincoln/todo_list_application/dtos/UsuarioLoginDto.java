package py.com.lincoln.todo_list_application.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioLoginDto {

    @NotBlank(message = "El nombre de usuario no puede estar vacío")
    private String nombreUsuario;

    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

}
