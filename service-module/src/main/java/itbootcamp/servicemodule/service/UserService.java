package itbootcamp.servicemodule.service;


import itbootcamp.repositorymodule.entity.User;
import itbootcamp.servicemodule.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto addUser(UserDto userDto);
}
