package py.com.lincoln.todo_list_application.services;

import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.dtos.UsuarioDto;
import py.com.lincoln.todo_list_application.mappers.Mapper;
import py.com.lincoln.todo_list_application.models.Usuario;
import py.com.lincoln.todo_list_application.repositories.UsuarioRepository;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    private final Mapper mapper;

    public UsuarioService(UsuarioRepository usuarioRepository, Mapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return usuarioRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }
}
