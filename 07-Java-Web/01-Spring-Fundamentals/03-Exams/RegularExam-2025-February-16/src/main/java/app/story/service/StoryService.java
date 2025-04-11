package app.story.service;

import app.story.model.Story;
import app.story.repository.StoryRepository;
import app.user.model.User;
import app.web.dto.AddStoryRequest;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Service
public class StoryService {


    private final StoryRepository storyRepository;

    public StoryService(StoryRepository storyRepository) {
        this.storyRepository = storyRepository;
    }

    public void addStory(AddStoryRequest addStoryRequest, User user) {

        Story story = Story.builder()
                .title(addStoryRequest.getTitle())
                .description(addStoryRequest.getDescription())
                .kind(addStoryRequest.getKind())
                .date(addStoryRequest.getDate())
                .addedOn(LocalTime.now())
                .owner(user)
                .isVisible(false)
                .build();

        storyRepository.save(story);
    }

    public void deleteStory(UUID storyId) {
        storyRepository.deleteById(storyId);
    }

    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    public Story getStoryById(UUID storyID) {
        return storyRepository.findById(storyID).orElseThrow(() -> new RuntimeException("Story with %s does not exists: ".formatted(storyID)));
    }

    public void shareStory(Story story) {
        story.setVisible(true);

        storyRepository.save(story);
    }
}
