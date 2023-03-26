package itbootcamp.webmodule;


import itbootcamp.repositorymodule.entity.User;
import itbootcamp.servicemodule.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    @GetMapping(path = "/all")
    public List<User> getCurrentWeather() {
        return userService.findAll();
    }
}
