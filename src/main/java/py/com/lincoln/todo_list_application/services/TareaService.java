package py.com.lincoln.todo_list_application.services;

import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.dtos.TareaDto;
import py.com.lincoln.todo_list_application.dtos.TareaEditDto;
import py.com.lincoln.todo_list_application.dtos.TareaInputDto;
import py.com.lincoln.todo_list_application.mappers.Mapper;
import py.com.lincoln.todo_list_application.models.Tarea;
import py.com.lincoln.todo_list_application.models.Usuario;
import py.com.lincoln.todo_list_application.repositories.TareaRepository;
import py.com.lincoln.todo_list_application.repositories.UsuarioRepository;

import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;

    private final UsuarioRepository usuarioRepository;

    private final Mapper mapper;

    public TareaService(TareaRepository tareaRepository, UsuarioRepository usuarioRepository, Mapper mapper) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public Tarea crearTarea(TareaInputDto input) {
        Usuario usuario = usuarioRepository.findById(input.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        Tarea tarea = new Tarea();
        tarea.setTitulo(input.getTitulo());
        tarea.setDescripcion(input.getDescripcion());
        tarea.setCompletado(false);
        tarea.setUsuario(usuario);
        return tareaRepository.save(tarea);
    }

    public List<TareaDto> obtenerTareas() {
        return tareaRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public Tarea actualizarTarea(Long idTarea, TareaEditDto input) {
        Usuario usuario = usuarioRepository.findById(input.getUsuarioId()).orElseThrow(() -> new RuntimeException("Usuario no encontrado."));
        Tarea tarea = tareaRepository.findById(idTarea).orElseThrow(() -> new RuntimeException("Tarea no encontrada."));
        tarea.setTitulo(input.getTitulo());
        tarea.setDescripcion(input.getDescripcion());
        tarea.setCompletado(input.getCompletado());
        tarea.setUsuario(usuario);
        return tareaRepository.save(tarea);
    }

    public String eliminarTarea(Long id) {
        tareaRepository.findById(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada."));
        tareaRepository.deleteById(id);
        return "Tarea eliminada con éxito.";
    }

}
