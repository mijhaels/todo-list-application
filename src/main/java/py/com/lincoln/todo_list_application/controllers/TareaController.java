package py.com.lincoln.todo_list_application.controllers;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import py.com.lincoln.todo_list_application.dtos.GenericResponse;
import py.com.lincoln.todo_list_application.dtos.TareaDto;
import py.com.lincoln.todo_list_application.dtos.TareaEditDto;
import py.com.lincoln.todo_list_application.dtos.TareaInputDto;
import py.com.lincoln.todo_list_application.models.Tarea;
import py.com.lincoln.todo_list_application.services.TareaService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping("/tarea")
    public ResponseEntity<GenericResponse<Tarea>> crearTarea(@RequestBody @Valid TareaInputDto input) {
        return ResponseEntity.ok(GenericResponse.success(tareaService.crearTarea(input)));
    }

    @GetMapping("/tareas")
    public ResponseEntity<GenericResponse<List<TareaDto>>> obtenerTareas() {
        return ResponseEntity.ok(GenericResponse.success(tareaService.obtenerTareas()));
    }

    @PutMapping("/tarea/{id}")
    public ResponseEntity<GenericResponse<Tarea>> actualizarTarea(@PathVariable("id") Long idTarea, @RequestBody @Valid TareaEditDto input) {
        return ResponseEntity.ok(GenericResponse.success(tareaService.actualizarTarea(idTarea, input)));
    }

    @DeleteMapping("/tarea/{id}")
    public ResponseEntity<GenericResponse<String>> eliminarTarea(@PathVariable("id") Long idTarea) {
        return ResponseEntity.ok(GenericResponse.success(tareaService.eliminarTarea(idTarea)));
    }

}
