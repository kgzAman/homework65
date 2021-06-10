package com.amanee.shope.Services;

import com.amanee.shope.Repositories.ClientRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class ClientService {
    private final ClientRepository clientRepository;

}
