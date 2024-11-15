package org.mapping.object.exercises.service;


import org.mapping.object.exercises.service.dtos.*;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface GameService {
    String addGame(GameCreateDTO gameCreateDTO);

    String editGame(GameEditDTO gameEditDTO);

    String deleteGame(int id);

    Set<GameViewDTO> getAllGames();

    GameDetailDTO getDetailGame(String title);

    String getOwnedGames();

    String addItem(String title);

    String removeItem(String title);

    String buyItem();
}
