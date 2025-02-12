package com.paintingscollectors.painting.service;

import com.paintingscollectors.painting.model.FavouritePainting;
import com.paintingscollectors.painting.model.Painting;
import com.paintingscollectors.painting.repository.FavouritePaintingRepository;
import com.paintingscollectors.painting.repository.PaintingRepository;
import com.paintingscollectors.user.model.User;
import com.paintingscollectors.web.dto.CreateNewPaintingRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class PaintingService {

    private final PaintingRepository paintingRepository;
    private final FavouritePaintingRepository favouritePaintingRepository;

    @Autowired
    public PaintingService(PaintingRepository paintingRepository, FavouritePaintingRepository favouritePaintingRepository) {
        this.paintingRepository = paintingRepository;
        this.favouritePaintingRepository = favouritePaintingRepository;
    }

    public List<Painting> getAllPaintings() {

        List<Painting> allPaintings = paintingRepository.findAll();

        allPaintings.sort(Comparator.comparing(Painting::getVotes).reversed().thenComparing(Painting::getName));

        return allPaintings;
    }

    public void deletePainting(UUID id) {
        paintingRepository.deleteById(id);
    }

    public void createNewPainting(CreateNewPaintingRequest newPaintingRequest, User user) {
        Painting painting = Painting.builder()
                .name(newPaintingRequest.getName())
                .author(newPaintingRequest.getAuthor())
                .style(newPaintingRequest.getStyle())
                .imageURL(newPaintingRequest.getImageURL())
                .owner(user)
                .votes(0)
                .build();

        paintingRepository.save(painting);
    }

    public void addPaintingToFavourite(UUID id, User user) {
        Painting painting = getById(id);

        FavouritePainting favouritePainting = FavouritePainting.builder()
                .name(painting.getName())
                .author(painting.getAuthor())
                .owner(user)
                .imageURL(painting.getImageURL())
                .createdOn(LocalDateTime.now())
                .build();


        favouritePaintingRepository.save(favouritePainting);
    }

    private Painting getById(UUID id) {
        return paintingRepository.findById(id).orElseThrow(() -> new RuntimeException("Painting with %s does not exists!".formatted(id)));
    }

    public void deletePaintingFromFavourite(UUID id) {
        favouritePaintingRepository.deleteById(id);
    }

    public void incrementVote(UUID id) {
        Painting painting = getById(id);

        painting.setVotes(painting.getVotes() + 1);

        paintingRepository.save(painting);
    }
}
