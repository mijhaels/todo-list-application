package py.com.lincoln.todo_list_application.advicers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RestAdvicer {

    private final static Logger LOGGER = LoggerFactory.getLogger(RestAdvicer.class);

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        LOGGER.error("Error no controlado {}", e.getMessage());
        return ResponseEntity.status(500).body(e.getMessage());
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        LOGGER.error("Error de integridad de datos {}", e.getMessage());
        return ResponseEntity.status(400).body("Error de integridad de datos");
    }

    @ExceptionHandler(value = {MethodArgumentTypeMismatchException.class, InvalidDataAccessApiUsageException.class})
    public ResponseEntity<String> handleMethodArgumentTypeMismatchException(Exception e) {
        LOGGER.error("Error de argumento no válido {}", e.getMessage());
        return ResponseEntity.status(400).body("Error de argumento no válido");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
