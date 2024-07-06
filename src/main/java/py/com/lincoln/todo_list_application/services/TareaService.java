package py.com.lincoln.todo_list_application.services;

import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.models.Tarea;
import py.com.lincoln.todo_list_application.models.Usuario;
import py.com.lincoln.todo_list_application.repositories.TareaRepository;

import java.util.List;

@Service
public class TareaService {

    private TareaRepository tareaRepository;

    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public Tarea guardarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public List<Tarea> obtenerTareas() {
        return tareaRepository.findAll();
    }

    public Tarea obtenerTareaPorId(Long id) {
        return tareaRepository.findById(id).orElse(null);
    }

    public List<Tarea> obtenerTareasPorUsuario(Usuario usuario) {
        return tareaRepository.findAllByUsuario(usuario);
    }

    public Tarea actualizarTarea(Tarea tarea) {
        return tareaRepository.save(tarea);
    }

    public String eliminarTarea(Long id) {
        tareaRepository.deleteById(id);
        return "Tarea eliminada con éxito.";
    }

}
