package org.json.processing.exercises.service.impls;

import com.google.gson.Gson;
import jakarta.validation.ConstraintViolation;
import org.json.processing.exercises.data.entities.User;
import org.json.processing.exercises.data.repository.UserRepository;
import org.json.processing.exercises.service.UserService;
import org.json.processing.exercises.service.dtos.export.*;
import org.json.processing.exercises.service.dtos.imports.UserSeedJsonDto;
import org.json.processing.exercises.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private static final String JSON_PATH = "src/main/resources/json/users.json";

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final Gson gson;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, Gson gson) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.gson = gson;
    }

    @Override
    public void seedUsers() throws IOException {
        UserSeedJsonDto[] userSeedJsonDtos = this.gson.fromJson(
                String.join("", Files.readAllLines(Path.of(JSON_PATH))), UserSeedJsonDto[].class);

        for (UserSeedJsonDto userSeedJsonDto : userSeedJsonDtos) {
            if (!this.validatorUtil.isValid(userSeedJsonDto)) {
                System.out.println(this.validatorUtil.validate(userSeedJsonDto)
                        .stream()
                        .map(ConstraintViolation::getMessage)
                        .collect(Collectors.joining()));

                continue;
            }

            this.userRepository.save(this.modelMapper.map(userSeedJsonDto, User.class));
        }
    }

    @Override
    public boolean isImported() {
        return this.userRepository.count() > 0;
    }

    @Override
    public void successfullySoldProducts() throws IOException {
        Set<User> allBySoldIsNotNull = this.userRepository.findAllBySoldIsNotNull();

        Set<UserSoldJsonDto> userSoldJsonDtos = allBySoldIsNotNull
                .stream()
                .map(u -> {
                    UserSoldJsonDto userSoldJsonDto = this.modelMapper.map(u, UserSoldJsonDto.class);

                    userSoldJsonDto.setSoldProducts(u.getSold()
                            .stream()
                            .map(p -> this.modelMapper.map(p, ProductSoldJsonDto.class))
                            .collect(Collectors.toSet()));

                    return userSoldJsonDto;
                }).collect(Collectors.toSet());

        String json = this.gson.toJson(userSoldJsonDtos);

        FileWriter fileWriter = new FileWriter("src/main/resources/json/export/users-sold-products.json");

        fileWriter.write(json);
        fileWriter.close();
    }

    @Override
    public void usersAndProducts() throws IOException {
        UserAndSoldProductDto userAndSoldProductDto = new UserAndSoldProductDto();

        Set<User> query = this.userRepository.findAllBySoldIsNotNullOrderBySoldDesc();

        Set<FullUserSoldJsonDto> fullUserSoldJsonDtos = query.stream()
                .map(u -> {
                    FullUserSoldJsonDto fullUserSoldJsonDto = this.modelMapper.map(u, FullUserSoldJsonDto.class);
                    SoldProductDto soldProductDto = new SoldProductDto();
                    soldProductDto.setCount(u.getSold().size());

                    soldProductDto.setProducts(u.getSold()
                            .stream()
                            .map(p -> this.modelMapper.map(p, ProductInfoDto.class))
                            .collect(Collectors.toSet()));

                    fullUserSoldJsonDto.setSoldProducts(soldProductDto);

                    return fullUserSoldJsonDto;
                })
                .collect(Collectors.toSet());

        userAndSoldProductDto.setUsersCount(query.size());
        userAndSoldProductDto.setUsers(fullUserSoldJsonDtos);

        String json = this.gson.toJson(userAndSoldProductDto);
        FileWriter fileWriter = new FileWriter("src/main/resources/json/export/users-and-products.json");

        fileWriter.write(json);
        fileWriter.close();
    }
}
