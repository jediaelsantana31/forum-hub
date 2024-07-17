package com.challenges.forum_hub.controller;

import com.challenges.forum_hub.dto.TopicCreationDTO;
import com.challenges.forum_hub.dto.TopicDetailDTO;
import com.challenges.forum_hub.dto.TopicUpdateDTO;
import com.challenges.forum_hub.service.TopicService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @PostMapping
    @Transactional
    public ResponseEntity<TopicDetailDTO> createTopic(@RequestBody @Valid TopicCreationDTO topicCreationDTO) {
        return ResponseEntity.ok(topicService.createTopic(topicCreationDTO));
    }

    @GetMapping
    public ResponseEntity<List<TopicDetailDTO>> listTopics(@PageableDefault(size = 10, sort = {"date"}) Pageable pageable) {
        return ResponseEntity.ok(topicService.listTopics(pageable));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicDetailDTO> updateTopic(@PathVariable Long id, @RequestBody @Valid TopicUpdateDTO topicUpdateDTO) {
        return ResponseEntity.ok(topicService.updateTopic(id, topicUpdateDTO));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteTopic(@PathVariable Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }
}
