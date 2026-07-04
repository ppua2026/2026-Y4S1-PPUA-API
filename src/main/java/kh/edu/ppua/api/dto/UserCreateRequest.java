package kh.edu.ppua.api.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateRequest {

    @NotBlank
    String username;
    @Size(min = 6, max = 12)
    String password;
    @Email
    String email;
    @NotNull
    @Min(18)
    Integer age;
}
