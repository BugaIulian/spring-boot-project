package ro.itschool.springboot.services;

import org.springframework.stereotype.Service;
import ro.itschool.springboot.models.dtos.UserDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    List<UserDTO> userDTOList = new ArrayList<>();

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        userDTOList.add(userDTO);
        return userDTO;
    }

    @Override
    public List<UserDTO> getUsers() {
        return userDTOList;
    }

    @Override
    public UserDTO deleteUserByName(String name) {

        for (UserDTO user : userDTOList) {
            if (user.getName().equalsIgnoreCase(name)) {
                userDTOList.remove(user);
                return user;
            }
        }
        return null;
    }
}
