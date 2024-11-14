package org.mapping.object.exercises.controller;

import org.mapping.object.exercises.service.GameService;
import org.mapping.object.exercises.service.UserService;
import org.mapping.object.exercises.service.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class Runner implements CommandLineRunner {

    private final UserService userService;
    private final GameService gameService;

    @Autowired
    public Runner(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public void run(String... args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        String command = "";

        while (!line.equals("stop")) {
            String[] tokens = line.split("\\|");
            String operation = tokens[0];

            switch (operation) {
                case "RegisterUser" -> command = this.userService.registerUser(
                        new UserCreateDTO(tokens[1], tokens[2], tokens[3], tokens[4]));
                case "LoginUser" -> command = this.userService.loginUser(
                        new UserLoginDTO(tokens[1], tokens[2]));
                case "Logout" -> command = this.userService.logout();
                case "AddGame" ->
                    command = this.gameService.addGame(new GameCreateDTO(
                            tokens[1], new BigDecimal(tokens[2]), Double.parseDouble(tokens[3]),
                            tokens[4], tokens[5], tokens[6],
                            LocalDate.parse(tokens[7], DateTimeFormatter.ofPattern("dd-MM-yyyy"))));
                case "EditGame" -> {
                    GameEditDTO gameEditDTO = new GameEditDTO();
                    gameEditDTO.setId(Integer.parseInt(tokens[1]));

                    Arrays.stream(tokens).skip(2).forEach(v -> {
                        String[] split = v.split("=");
                        String field = split[0];

                        if ("price".equals(field)) {
                            gameEditDTO.setPrice(new BigDecimal(split[1]));
                        } else if ("size".equals(field)) {
                            gameEditDTO.setSize(Double.parseDouble(split[1]));
                        }
                    });

                    command = this.gameService.editGame(gameEditDTO);
                }
                case "DeleteGame" -> command = this.gameService.deleteGame(Integer.parseInt(tokens[1]));
                case "AllGames" -> command = this.gameService.getAllGames()
                        .stream()
                        .map(GameViewDTO::toString)
                        .collect(Collectors.joining("\n"));
                case "DetailGame" -> command = this.gameService.getDetailGame(tokens[1]).toString();
                case "OwnedGames" -> command = this.gameService.getOwnedGames();
                case "AddItem" -> command = this.gameService.addItem(tokens[1]);
                case "RemoveItem" -> command = this.gameService.removeItem(tokens[1]);
                case "BuyItem" -> command = this.gameService.buyItem();
            }

            System.out.println(command);
            line = reader.readLine();
        }
    }
}
