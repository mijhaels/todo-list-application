package py.com.lincoln.todo_list_application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import py.com.lincoln.todo_list_application.dtos.UsuarioDto;
import py.com.lincoln.todo_list_application.dtos.UsuarioInputDto;
import py.com.lincoln.todo_list_application.models.Usuario;
import py.com.lincoln.todo_list_application.services.UsuarioService;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDto>> obtenerUsuarios() {
        return ResponseEntity.ok(usuarioService.obtenerUsuarios());
    }

    @PostMapping("/usuario")
    public ResponseEntity<Usuario> crearUsuario(@RequestBody @Valid UsuarioInputDto usuario) {
        return ResponseEntity.ok(usuarioService.crearUsuario(usuario));
    }

}
