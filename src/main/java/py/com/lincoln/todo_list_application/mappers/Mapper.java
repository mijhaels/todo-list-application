package py.com.lincoln.todo_list_application.mappers;

import org.springframework.stereotype.Component;
import py.com.lincoln.todo_list_application.dtos.UsuarioDto;
import py.com.lincoln.todo_list_application.models.Usuario;

@Component
public class Mapper {
    public UsuarioDto toDto(Usuario entity) {
        return new UsuarioDto(entity.getNombreUsuario(), entity.getTareas());
    }

}
