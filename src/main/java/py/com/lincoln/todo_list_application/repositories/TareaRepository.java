package py.com.lincoln.todo_list_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.lincoln.todo_list_application.models.Tarea;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
}