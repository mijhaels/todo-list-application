package py.com.lincoln.todo_list_application.enums;

import lombok.Getter;

@Getter
public enum UsuarioRoles {
    ADMIN("admin"),
    USUARIO("usuario");

    private final String rol;

    UsuarioRoles(String rol) {
        this.rol = rol;
    }
}
