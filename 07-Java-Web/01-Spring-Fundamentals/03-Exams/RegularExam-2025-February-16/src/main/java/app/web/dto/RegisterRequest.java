package app.web.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterRequest {

    @NotNull
    @Size(min = 4, max = 20, message = "Username length must be between 4 and 20 characters")
    private String username;

    @NotNull
    @Size(min = 4, max = 20, message = "The password must be between 4 and 20 characters")
    private String password;
}
