package itbootcamp.servicemodule.service.impl;

import itbootcamp.repositorymodule.entity.User;
import itbootcamp.repositorymodule.repository.UserRepository;
import itbootcamp.servicemodule.dto.UserDto;
import itbootcamp.servicemodule.dto.UserResponse;
import itbootcamp.servicemodule.mapper.UserMapper;
import itbootcamp.servicemodule.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        log.info("Found all users");
        return userMapper.listToDto(userRepository.findAll());
    }

    @Override
    public UserDto addUser(UserDto userDto) {
        log.info("User saved");
        return userMapper.toDto(userRepository.save(userMapper.toEntity(userDto)));
    }

    @Override
    public UserResponse getAllUsers(int pageNo, int pageSize, String sortBy, String sortDir) {

        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);

        Page<User> users = userRepository.findAll(pageable);
        List<User> listOfUsers = users.getContent();

        List<UserDto> content= userMapper.listToDto(listOfUsers);

        UserResponse userResponse = new UserResponse();
        userResponse.setContent(content);
        userResponse.setPageNo(users.getNumber());
        userResponse.setPageSize(users.getSize());
        userResponse.setTotalElements(users.getTotalElements());
        userResponse.setTotalPages(users.getTotalPages());
        userResponse.setLast(users.isLast());
        log.info("Found all users with pagination");
        return userResponse;
    }

}

