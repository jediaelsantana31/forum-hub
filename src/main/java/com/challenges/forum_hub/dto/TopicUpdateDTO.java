package com.challenges.forum_hub.dto;

import com.challenges.forum_hub.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TopicUpdateDTO {

    private String title;
    private String message;
    private Course course;
}
