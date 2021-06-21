package com.amanee.shope.services;

import com.amanee.shope.dto.UserDTO;
import com.amanee.shope.dto.UserResponseDTO;
import com.amanee.shope.entity.User;
import com.amanee.shope.entity.UserRegisterForm;
import com.amanee.shope.exeption.UserAlreadyRegisteredException;
import com.amanee.shope.exeption.UserNotFoundException;
import com.amanee.shope.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public UserResponseDTO register(UserRegisterForm form) {
        if (repository.existsByEmail(form.getEmail())) {
            throw new UserAlreadyRegisteredException();
        }

        var user = User.builder()
                .email(form.getEmail())
                .name(form.getName())
                .password(encoder.encode(form.getPassword()))
                .build();

        repository.save(user);

        return UserResponseDTO.from(user);
    }

    public UserResponseDTO getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);

        return UserResponseDTO.from(user);
    }

    public void addUser(UserDTO userDTO){

    }

}
