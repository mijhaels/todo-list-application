package py.com.lincoln.todo_list_application.services;

import org.springframework.stereotype.Service;
import py.com.lincoln.todo_list_application.dtos.UsuarioDto;
import py.com.lincoln.todo_list_application.dtos.UsuarioInputDto;
import py.com.lincoln.todo_list_application.dtos.UsuarioLoginDto;
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

    public Usuario crearUsuario(UsuarioInputDto input) {
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario(input.getNombreUsuario());
        usuario.setPassword(input.getPassword());
        usuario.setRol(input.getRol());
        usuario.setNombre(input.getNombre());
        usuario.setApellido(input.getApellido());
        return usuarioRepository.save(usuario);
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return usuarioRepository.findAll().stream().map(mapper::toDto).toList();
    }

    public String login(UsuarioLoginDto login) {
        usuarioRepository.findByNombreUsuarioAndPassword(login.getNombreUsuario(), login.getPassword()).orElseThrow(() -> new IllegalArgumentException("Credenciales inválidas"));
        return "Usuario logueado con éxito";
    }

}
