package br.com.users.endpoint.service;

import br.com.users.endpoint.dto.LoginDTO;
import br.com.users.endpoint.dto.UserDTO;
import br.com.users.endpoint.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAll();
    User findById(String id);
    User save(UserDTO userDTO);
    User update(String id, UserDTO userDTO);
    void delete(String id);
    User logar(LoginDTO loginDTO);

}
