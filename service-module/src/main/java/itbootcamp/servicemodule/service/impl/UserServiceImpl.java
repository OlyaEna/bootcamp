package itbootcamp.servicemodule.service.impl;

import itbootcamp.repositorymodule.entity.User;
import itbootcamp.repositorymodule.repository.UserRepository;
import itbootcamp.servicemodule.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public List<User> findAll(){
       return userRepository.findAll();
    }
}
