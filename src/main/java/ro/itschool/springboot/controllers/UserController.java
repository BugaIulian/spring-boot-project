package ro.itschool.springboot.controllers;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.itschool.springboot.models.dtos.OrderDTO;
import ro.itschool.springboot.models.dtos.UserDTO;
import ro.itschool.springboot.repositories.OrderRepository;
import ro.itschool.springboot.services.UserService;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/api/users")
    public ResponseEntity<UserDTO> createUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }

    @PutMapping("/api/users")
    public ResponseEntity<UserDTO> updateUser(@RequestBody @Valid UserDTO userDTO) {
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @DeleteMapping("/api/users/{id}")
    public void deleteUserById(@PathVariable long id) {
        userService.deleteUserById(id);
    }

    @PostMapping("/api/{userId}/orders")
    public ResponseEntity<OrderDTO> createOrderByUserId(@PathVariable @NotNull Long userId, @RequestBody @Valid OrderDTO orderDTO) {
        return ResponseEntity.ok(userService.createOrder(userId, orderDTO));
    }
}