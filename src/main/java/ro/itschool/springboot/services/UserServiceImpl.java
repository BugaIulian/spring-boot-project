package ro.itschool.springboot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ro.itschool.springboot.models.dtos.UserDTO;
import ro.itschool.springboot.models.entities.User;
import ro.itschool.springboot.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User userToSave = objectMapper.convertValue(userDTO, User.class);
        User userSaved = userRepository.save(userToSave);
        UserDTO userSavedDTO = objectMapper.convertValue(userSaved, UserDTO.class);
        return userSavedDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<User> savedUsers = userRepository.findAll();
        List<UserDTO> savedUsersDTO = new ArrayList<>();
        savedUsers.forEach(user -> {
            savedUsersDTO.add(objectMapper.convertValue(user, UserDTO.class));
        });
        return savedUsersDTO;
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }
}