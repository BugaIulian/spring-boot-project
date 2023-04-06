package ro.itschool.springboot.models.dtos;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String name;
    private String email;
    private int age;
}