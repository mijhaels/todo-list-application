package py.com.lincoln.todo_list_application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import py.com.lincoln.todo_list_application.models.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByNombreUsuarioAndPassword(String nombreUsuario, String password);

}