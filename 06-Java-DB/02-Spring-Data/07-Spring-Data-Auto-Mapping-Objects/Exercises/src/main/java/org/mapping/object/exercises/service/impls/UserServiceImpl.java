package org.mapping.object.exercises.service.impls;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;
import org.mapping.object.exercises.data.entities.User;
import org.mapping.object.exercises.data.repositories.UserRepository;
import org.mapping.object.exercises.service.UserService;
import org.mapping.object.exercises.service.dtos.UserCreateDTO;
import org.mapping.object.exercises.service.dtos.UserLoginDTO;
import org.mapping.object.exercises.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;

    private User user;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
    }

    @Override
    public String registerUser(UserCreateDTO userCreateDTO) {
        if (!userCreateDTO.getPassword().equals(userCreateDTO.getConfirmPassword())) {
            return "Passwords do not match";
        }

        if (!validatorUtil.isValid(userCreateDTO)) {
            return validatorUtil.validate(userCreateDTO)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }

        if (this.userRepository.findByEmail(userCreateDTO.getEmail()).isPresent()) {
            return "Email address already in use";
        }

        User user = this.modelMapper.map(userCreateDTO, User.class);
        setRootUserAdmin(user);

        this.userRepository.saveAndFlush(user);

        return String.format("%s was registered", user.getFullName());
    }

    @Override
    public String loginUser(UserLoginDTO userLoginDTO) {
        Optional<User> user = this.userRepository.findByEmailAndPassword(
                userLoginDTO.getEmail(), userLoginDTO.getPassword());

        if (user.isEmpty()) {
            return "Invalid email or password";
        } else {
            this.user = user.get();
            return String.format("Successfully logged in %s", user.get().getFullName());
        }
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public boolean isLoggedIn() {
        return this.user != null;
    }

    @Override
    public boolean isAdmin() {
        return this.isLoggedIn() && this.user.isAdmin();
    }

    @Override
    public String logout() {
        if (this.isLoggedIn()) {
            String result = String.format("User %s successfully logged out", this.user.getFullName());
            this.user = null;

            return result;
        }

        return "No logged in user";
    }

    private void setRootUserAdmin(User user) {
        if (this.userRepository.count() == 0) {
            user.setAdmin(true);
        }
    }
}
