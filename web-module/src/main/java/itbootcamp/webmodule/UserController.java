package itbootcamp.webmodule;

import itbootcamp.servicemodule.dto.UserDto;
import itbootcamp.servicemodule.dto.UserResponse;
import itbootcamp.servicemodule.service.UserService;
import itbootcamp.webmodule.constants.AppConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;


    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);
        log.info("Controller: addUser");
        return new   ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public UserResponse getAllPageUsers(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) int pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) int pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy,
            @RequestParam(value = "sortDir", defaultValue = AppConstants.DEFAULT_SORT_DIRECTION, required = false) String sortDir
    ) {
        log.info("Controller: getAllPageUsers");
        return userService.getAllUsers(pageNo, pageSize, sortBy, sortDir);
    }


    @GetMapping(path = "/getAll")
    public List<UserDto> getAllUsers() {
        log.info("Controller: getAllUsers");
        return userService.findAll();
    }

}
