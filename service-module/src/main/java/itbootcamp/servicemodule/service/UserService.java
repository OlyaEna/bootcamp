package itbootcamp.servicemodule.service;


import itbootcamp.repositorymodule.entity.User;
import itbootcamp.servicemodule.dto.UserDto;
import itbootcamp.servicemodule.dto.UserResponse;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    UserDto addUser(UserDto userDto);
    UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir);
}
