package com.challenges.forum_hub.dto;

import com.challenges.forum_hub.entity.Course;
import com.challenges.forum_hub.entity.Topic;
import lombok.Getter;

@Getter
public class TopicDetailDTO {

    private Long id;
    private String title;
    private String message;
    private boolean status;
    private Course course;

    public TopicDetailDTO(Topic topic) {
        this.id = topic.getId();
        this.title = topic.getTitle();
        this.message = topic.getMessage();
        this.status = topic.isStatus();
        this.course = topic.getCourse();
    }
}