package py.com.lincoln.todo_list_application.mappers;

import org.springframework.stereotype.Component;
import py.com.lincoln.todo_list_application.dtos.TareaDto;
import py.com.lincoln.todo_list_application.dtos.UsuarioDto;
import py.com.lincoln.todo_list_application.models.Tarea;
import py.com.lincoln.todo_list_application.models.Usuario;

@Component
public class Mapper {
    public UsuarioDto toDto(Usuario entity) {
        return new UsuarioDto(entity.getNombreUsuario(), entity.getNombre(), entity.getApellido());
    }

    public TareaDto toDto(Tarea entity) {
        return new TareaDto(entity.getTitulo(), entity.getDescripcion(), entity.getCompletado(), entity.getUsuario());
    }

}
