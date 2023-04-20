package ro.itschool.springboot.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ro.itschool.springboot.models.dtos.OrderDTO;
import ro.itschool.springboot.models.dtos.UserDTO;
import ro.itschool.springboot.models.entities.OrderEntity;
import ro.itschool.springboot.models.entities.UserEntity;
import ro.itschool.springboot.repositories.OrderRepository;
import ro.itschool.springboot.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private OrderRepository orderRepository;
    private ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ObjectMapper objectMapper, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.objectMapper = objectMapper;
        this.orderRepository = orderRepository;
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        UserEntity userEntityToSave = objectMapper.convertValue(userDTO, UserEntity.class);
        UserEntity userEntitySaved = userRepository.save(userEntityToSave);
        UserDTO userSavedDTO = objectMapper.convertValue(userEntitySaved, UserDTO.class);
        return userSavedDTO;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public List<UserDTO> getUsers() {
        List<UserEntity> savedUserEntities = userRepository.findAll();
        List<UserDTO> savedUsersDTO = new ArrayList<>();
        savedUserEntities.forEach(userEntity -> {
            savedUsersDTO.add(objectMapper.convertValue(userEntity, UserDTO.class));
        });
        return savedUsersDTO;
    }

    @Override
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public OrderDTO createOrder(Long userId, OrderDTO orderDTO) {
        UserEntity userFound = userRepository.findById(userId).orElseThrow();
        OrderEntity order = objectMapper.convertValue(orderDTO, OrderEntity.class);
        order.setUser(userFound);
        OrderEntity orderSaved = orderRepository.save(order);
        return objectMapper.convertValue(orderSaved, OrderDTO.class);
    }
}