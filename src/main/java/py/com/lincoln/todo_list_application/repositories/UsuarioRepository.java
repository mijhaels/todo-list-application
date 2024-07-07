package py.com.lincoln.todo_list_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.lincoln.todo_list_application.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByNombreUsuarioAndPassword(String nombreUsuario, String password);

}