package py.com.lincoln.todo_list_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.lincoln.todo_list_application.models.Tarea;
import py.com.lincoln.todo_list_application.models.Usuario;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {

    List<Tarea> findAllByUsuario(Usuario usuario);

}