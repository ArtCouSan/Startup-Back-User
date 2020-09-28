package br.com.users.endpoint.repository;

import br.com.users.endpoint.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    public Optional<User> findByEmailAndPassword(String email, String password);

}
