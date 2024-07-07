package py.com.lincoln.todo_list_application.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GenericResponse<T> {
    private boolean success;
    private String message;
    private T data;

    public static <T> GenericResponse<T> empty() {
        return success(null);
    }

    public static <T> GenericResponse<T> success(T data) {
        return GenericResponse.<T>builder()
                .message("¡ÉXITO!")
                .data(data)
                .success(true)
                .build();
    }

    public static <T> GenericResponse<T> error(String error) {
        return GenericResponse.<T>builder()
                .message(error)
                .success(false)
                .build();
    }
}