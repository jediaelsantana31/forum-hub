package com.challenges.forum_hub.dto;

import com.challenges.forum_hub.entity.Course;
import com.challenges.forum_hub.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopicCreationDTO {

    private String title;
    private String message;
    private LocalDateTime date;
    private boolean status;
    private Course course;
    private User user;
}
