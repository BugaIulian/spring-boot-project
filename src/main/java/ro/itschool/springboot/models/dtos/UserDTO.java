package ro.itschool.springboot.models.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String name;
    @NotNull(message = "Email is mandatory")
    private String email;
    private int age;
}