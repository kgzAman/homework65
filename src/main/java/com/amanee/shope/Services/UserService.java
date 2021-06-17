package com.amanee.shope.Services;

import com.amanee.shope.Entity.User;
import com.amanee.shope.Repositories.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserService {

    private final UserRepository userRepository;

    public User getById(Integer id){
        return userRepository.findById(id).orElseThrow();
    }

}
