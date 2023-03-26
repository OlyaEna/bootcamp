package itbootcamp.servicemodule.service.impl;

import itbootcamp.repositorymodule.entity.User;
import itbootcamp.repositorymodule.repository.UserRepository;
import itbootcamp.servicemodule.dto.UserDto;
import itbootcamp.servicemodule.mapper.UserMapper;
import itbootcamp.servicemodule.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userMapper.listToDto(userRepository.findAll());
    }

    @Override
    public UserDto addUser(UserDto userDto) {
         return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

}

