package py.com.lincoln.todo_list_application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.lincoln.todo_list_application.dtos.GenericResponse;
import py.com.lincoln.todo_list_application.dtos.UsuarioDto;
import py.com.lincoln.todo_list_application.dtos.UsuarioInputDto;
import py.com.lincoln.todo_list_application.dtos.UsuarioLoginDto;
import py.com.lincoln.todo_list_application.models.Usuario;
import py.com.lincoln.todo_list_application.services.UsuarioService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<GenericResponse<List<UsuarioDto>>> obtenerUsuarios() {
        return ResponseEntity.ok(GenericResponse.success(usuarioService.obtenerUsuarios()));
    }

    @PostMapping("/usuario")
    public ResponseEntity<GenericResponse<Usuario>> crearUsuario(@RequestBody @Valid UsuarioInputDto usuario) {
        return ResponseEntity.ok(GenericResponse.success(usuarioService.crearUsuario(usuario)));
    }

    @PostMapping("/usuario/login")
    public ResponseEntity<GenericResponse<String>> login(@RequestBody @Valid UsuarioLoginDto login) {
        return ResponseEntity.ok(GenericResponse.success(usuarioService.login(login)));
    }

}
