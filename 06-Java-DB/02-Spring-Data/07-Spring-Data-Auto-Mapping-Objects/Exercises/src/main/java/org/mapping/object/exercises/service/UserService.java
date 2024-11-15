package org.mapping.object.exercises.service;

import org.mapping.object.exercises.data.entities.User;
import org.mapping.object.exercises.service.dtos.UserCreateDTO;
import org.mapping.object.exercises.service.dtos.UserLoginDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String registerUser(UserCreateDTO userCreateDTO);

    String loginUser(UserLoginDTO userLoginDTO);

    User getUser();

    boolean isLoggedIn();

    boolean isAdmin();

    String logout();

}
