package itbootcamp.webmodule;

import itbootcamp.servicemodule.dto.UserDto;
import itbootcamp.servicemodule.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/getAll")
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        UserDto user = userService.addUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
