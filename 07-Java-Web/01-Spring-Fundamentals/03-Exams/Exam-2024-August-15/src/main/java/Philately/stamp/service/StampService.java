package Philately.stamp.service;

import Philately.stamp.model.Stamp;
import Philately.stamp.model.WishedStamp;
import Philately.stamp.repository.StampRepository;
import Philately.stamp.repository.WishedStampRepository;
import Philately.user.model.User;
import Philately.web.dto.CreateNewStampRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StampService {

    private final StampRepository stampRepository;
    private final WishedStampRepository wishedStampRepository;

    @Autowired
    public StampService(StampRepository stampRepository, WishedStampRepository wishedStampRepository) {
        this.stampRepository = stampRepository;
        this.wishedStampRepository = wishedStampRepository;
    }

    public List<Stamp> getAllStamps() {
        return stampRepository.findAll();
    }

    public void createNewStamp(CreateNewStampRequest createNewStampRequest, User user) {
        Stamp stamp = Stamp.builder()
                .name(createNewStampRequest.getName())
                .description(createNewStampRequest.getDescription())
                .paper(createNewStampRequest.getPaper())
                .imageURL(createNewStampRequest.getImageURL())
                .owner(user)
                .build();

        stampRepository.save(stamp);
    }

    public void addStampToWishlist(UUID id, User user) {
        Stamp stamp = getStampById(id);

        WishedStamp wishedStamp = WishedStamp.builder()
                .name(stamp.getName())
                .description(stamp.getDescription())
                .imageURL(stamp.getImageURL())
                .owner(user)
                .build();

        wishedStampRepository.save(wishedStamp);
    }

    private Stamp getStampById(UUID id) {
        return stampRepository.findById(id).orElseThrow(() -> new RuntimeException("Stamp does not exist!"));
    }

    public void removeStampFromWishlist(UUID id) {
        wishedStampRepository.deleteById(id);
    }
}
