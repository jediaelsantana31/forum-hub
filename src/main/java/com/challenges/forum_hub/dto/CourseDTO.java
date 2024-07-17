package com.challenges.forum_hub.dto;

import com.challenges.forum_hub.entity.Course;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {

    private Long id;
    private String name;
    private String category;

    public CourseDTO(Course course) {
        this.id = course.getId();
        this.name = course.getName();
        this.category = course.getCategory();
    }
}