package py.com.lincoln.todo_list_application.advicers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import py.com.lincoln.todo_list_application.dtos.GenericResponse;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestAdvicer {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestAdvicer.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GenericResponse<String>> handleException(Exception e) {
        LOGGER.error("Error no controlado {}", e.getMessage());
        return ResponseEntity.status(500).body(GenericResponse.error(e.getMessage()));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<GenericResponse<String>> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        LOGGER.error("Error de integridad de datos {}", e.getMessage());
        return ResponseEntity.status(400).body(GenericResponse.error("Error de integridad de datos"));
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, InvalidDataAccessApiUsageException.class})
    public ResponseEntity<GenericResponse<String>> handleMethodArgumentTypeMismatchException(Exception e) {
        LOGGER.error("Error de argumento no válido {}", e.getMessage());
        return ResponseEntity.status(400).body(GenericResponse.error("Error de argumento no válido"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<GenericResponse<String>> handleIllegalArgumentException(IllegalArgumentException e) {
        LOGGER.error("Error de argumento no válido {}", e.getMessage());
        return ResponseEntity.status(400).body(GenericResponse.error(e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<GenericResponse<Map<String, String>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.status(400).body(GenericResponse.error(errors.toString()));
    }
}
