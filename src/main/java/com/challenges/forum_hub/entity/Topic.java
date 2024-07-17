package com.challenges.forum_hub.entity;

import com.challenges.forum_hub.dto.TopicCreationDTO;
import com.challenges.forum_hub.dto.TopicUpdateDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "topics")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String message;
    private LocalDateTime date;
    private boolean status;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Topic(TopicCreationDTO dto) {
        this.title = dto.getTitle();
        this.message = dto.getMessage();
        this.date = dto.getDate();
        this.status = dto.isStatus();
        this.course = dto.getCourse();
        this.user = dto.getUser();
    }

    public void update(TopicUpdateDTO dto) {
        if (dto.getTitle() != null) {
            this.title = dto.getTitle();
        }
        if (dto.getMessage() != null) {
            this.message = dto.getMessage();
        }
        if (dto.getCourse() != null) {
            this.course = dto.getCourse();
        }
    }
}
