package itbootcamp.servicemodule.service;


import itbootcamp.repositorymodule.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
