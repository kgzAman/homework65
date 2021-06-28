package com.amanee.shope.services;

import com.amanee.shope.dto.UserDTO;
import com.amanee.shope.dto.UserResponseDTO;
import com.amanee.shope.entity.User;
import com.amanee.shope.entity.UserRegisterForm;
import com.amanee.shope.exeption.UserAlreadyRegisteredException;
import com.amanee.shope.exeption.NotFoundException;
import com.amanee.shope.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.aspectj.weaver.ast.Not;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Data
@AllArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder encoder;
    private final PasswordEncoder passwordEncoder;


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

    public User getByEmail(String email) {
        var user = repository.findByEmail(email)
                .orElseThrow(NotFoundException::new);
        return user;
    }

    public void addUser(UserDTO userDTO){

    }

    public User getByName(String username) {
        return repository.findByName(username).orElseThrow(NotFoundException::new);
    }


    private String randomStringGenerator(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    public String getPassword(String email) {
        final User user=this.repository.findByEmail(email).orElseThrow(NotFoundException::new);
        return updatePassword(user);
    }

    private String updatePassword(User user){
        String newPassword = randomStringGenerator();
        user.setPassword(passwordEncoder.encode(newPassword));
        this.repository.save(user);
        return newPassword;
    }
}
