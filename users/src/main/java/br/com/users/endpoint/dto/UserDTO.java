package br.com.users.endpoint.dto;

import br.com.users.endpoint.entity.User;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class UserDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDate dateBirth;
    private String genre;
    private String phoneNumber;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.dateBirth = user.getDateBirth();
        this.genre = user.getGenre();
        this.phoneNumber = user.getPhoneNumber();
    }
}
