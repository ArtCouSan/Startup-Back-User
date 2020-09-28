package br.com.users.endpoint.controller;

import br.com.users.endpoint.dto.LoginDTO;
import br.com.users.endpoint.dto.UserDTO;
import br.com.users.endpoint.entity.User;
import br.com.users.endpoint.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/user")
public class UsersController {

    private UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public User findById(@RequestParam String id) {
        return userService.findById(id);
    }

    @PostMapping
    public User save(@RequestBody UserDTO userDTO) {
        return userService.save(userDTO);
    }

    @PutMapping({"id"})
    public User update(@RequestParam String id, @RequestBody UserDTO userDTO) {
        return userService.update(id, userDTO);
    }

    @DeleteMapping({"id"})
    public void delete(@RequestParam String id) {
        userService.delete(id);
    }

    @PostMapping("/logar")
    public User logar(@RequestBody LoginDTO loginDTO) {
        return userService.logar(loginDTO);
    }

}
