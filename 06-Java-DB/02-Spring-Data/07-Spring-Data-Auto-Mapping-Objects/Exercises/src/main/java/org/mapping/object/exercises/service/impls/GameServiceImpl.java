package org.mapping.object.exercises.service.impls;

import jakarta.validation.ConstraintViolation;
import org.mapping.object.exercises.data.entities.Game;
import org.mapping.object.exercises.data.entities.User;
import org.mapping.object.exercises.data.repositories.GameRepository;
import org.mapping.object.exercises.data.repositories.UserRepository;
import org.mapping.object.exercises.service.GameService;
import org.mapping.object.exercises.service.UserService;
import org.mapping.object.exercises.service.dtos.*;
import org.mapping.object.exercises.utils.ValidatorUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ValidatorUtil validatorUtil;
    private final UserService userService;

    private final Set<Game> games = new HashSet<>();

    @Autowired
    public GameServiceImpl(GameRepository gameRepository, UserRepository userRepository, ModelMapper modelMapper, ValidatorUtil validatorUtil, UserService userService) {
        this.gameRepository = gameRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.validatorUtil = validatorUtil;
        this.userService = userService;
    }

    @Override
    public String addGame(GameCreateDTO gameCreateDTO) {
        if (!this.userService.isAdmin()) {
            return "User is not admin";
        }

        if (!this.validatorUtil.isValid(gameCreateDTO)) {
            return this.validatorUtil.validate(gameCreateDTO)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }

        Game game = this.modelMapper.map(gameCreateDTO, Game.class);
        this.gameRepository.saveAndFlush(game);

        return String.format("Added %s", game.getTitle());
    }

    @Override
    public String editGame(GameEditDTO gameEditDTO) {
        if (!this.userService.isAdmin()) {
            return "User is not admin";
        }

        if (!this.validatorUtil.isValid(gameEditDTO)) {
            return this.validatorUtil.validate(gameEditDTO)
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining("\n"));
        }

        Optional<Game> optionalGame = this.gameRepository.findById(gameEditDTO.getId());

        if (optionalGame.isEmpty()) {
            return "No such game found";
        }

        Game game = optionalGame.get();

        if (gameEditDTO.getPrice() != null) {
            game.setPrice(gameEditDTO.getPrice());
        }

        if (gameEditDTO.getSize() != null) {
            game.setSize(gameEditDTO.getSize());
        }

        this.gameRepository.saveAndFlush(game);

        return String.format("Edited %s", game.getTitle());
    }

    @Override
    public String deleteGame(int id) {
        if (!this.userService.isAdmin()) {
            return "User is not admin";
        }

        Optional<Game> game = this.gameRepository.findById(id);

        if (game.isEmpty()) {
            return "No such game found";
        }

        this.gameRepository.delete(game.get());

        return String.format("Deleted %s", game.get().getTitle());
    }

    @Override
    public Set<GameViewDTO> getAllGames() {
        return this.gameRepository.findAll()
                .stream()
                .map(game -> this.modelMapper.map(game, GameViewDTO.class))
                .collect(Collectors.toSet());
    }

    @Override
    public GameDetailDTO getDetailGame(String title) {
        Optional<Game> game = this.gameRepository.findByTitle(title);

        return game.map(value -> this.modelMapper
                        .map(value, GameDetailDTO.class))
                .orElse(new GameDetailDTO());
    }

    @Override
    public String getOwnedGames() {
        if (!this.userService.isLoggedIn()) {
            return "No logged in user";
        }

        return this.userService.getUser().getGames()
                .stream()
                .map(game -> this.modelMapper.map(game, GameOwnedDTO.class))
                .map(GameOwnedDTO::getTitle)
                .collect(Collectors.joining("\n"));
    }

    @Override
    public String addItem(String title) {
        if (!this.userService.isLoggedIn()) {
            return "No logged in user";
        }

        Optional<Game> game = this.gameRepository.findByTitle(title);

        if (game.isEmpty()) {
            return "No such game found";
        }

        this.games.add(game.get());

        return String.format("%s added to cart", game.get().getTitle());
    }

    @Override
    public String removeItem(String title) {
        if (!this.userService.isLoggedIn()) {
            return "No logged in user";
        }

        Optional<Game> game = this.gameRepository.findByTitle(title);

        if (game.isEmpty()) {
            return "No such game found";
        }

        if (this.games.contains(game.get())) {
            this.games.remove(game.get());

            return String.format("%s removed from cart", game.get().getTitle());
        }

        return "No such game found in cart";
    }

    @Override
    public String buyItem() {
        if (!this.userService.isLoggedIn()) {
            return "No logged in user";
        }

        User user = this.userService.getUser();
        Set<Game> newGames = this.games.stream()
                .filter(g -> !user.getGames().contains(g))
                .collect(Collectors.toSet());

        user.getGames().addAll(newGames);
        this.userRepository.saveAndFlush(user);

        return String.format("Successfully bought games:\n\t%s", newGames.stream()
                .map(Game::getTitle)
                .collect(Collectors.joining("\n")));
    }
}

