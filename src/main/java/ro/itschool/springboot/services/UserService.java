package ro.itschool.springboot.services;

import ro.itschool.springboot.models.dtos.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO updateUser(UserDTO userDTO);

    List<UserDTO> getUsers();
    UserDTO deleteUserByName(String name);
}