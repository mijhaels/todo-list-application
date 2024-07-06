package py.com.lincoln.todo_list_application.enums;

public enum UsuarioRoles {
    ADMIN("admin"),
    USUARIO("usuario");

    private final String rol;

    UsuarioRoles(String rol) {
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }
}
