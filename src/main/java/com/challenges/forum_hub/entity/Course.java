package com.challenges.forum_hub.entity;

import com.challenges.forum_hub.dto.CourseDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String category;

    public Course(CourseDTO dto) {
        this.name = dto.getName();
        this.category = dto.getCategory();
    }

    public void update(CourseDTO dto) {
        if (dto.getName() != null) {
            this.name = dto.getName();
        }
        if (dto.getCategory() != null) {
            this.category = dto.getCategory();
        }
    }
}