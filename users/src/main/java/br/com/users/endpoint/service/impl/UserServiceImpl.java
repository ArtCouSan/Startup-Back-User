package br.com.users.endpoint.service.impl;

import br.com.users.endpoint.dto.LoginDTO;
import br.com.users.endpoint.dto.UserDTO;
import br.com.users.endpoint.entity.User;
import br.com.users.endpoint.repository.UserRepository;
import br.com.users.endpoint.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User save(UserDTO userDTO) {
        return userRepository.save(new User(userDTO));
    }

    @Override
    public User update(String id, UserDTO userDTO) {
        User user = userRepository.findById(id).get();
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setDateBirth(userDTO.getDateBirth());
        user.setGenre(userDTO.getGenre());
        user.setGenre(userDTO.getPhoneNumber());

        return userRepository.save(user);
    }

    @Override
    public void delete(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User logar(LoginDTO loginDTO) {

        Optional<User> userOptional = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());

        if(userOptional.isPresent()){
            return userOptional.get();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }

    }
}
