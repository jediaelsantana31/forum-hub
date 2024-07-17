package com.challenges.forum_hub.service;



import com.challenges.forum_hub.dto.TopicCreationDTO;
import com.challenges.forum_hub.dto.TopicDetailDTO;
import com.challenges.forum_hub.dto.TopicUpdateDTO;
import com.challenges.forum_hub.entity.Topic;
import com.challenges.forum_hub.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public TopicDetailDTO createTopic(TopicCreationDTO topicCreationDTO) {
        Topic topic = new Topic(topicCreationDTO);
        topicRepository.save(topic);
        return new TopicDetailDTO(topic);
    }

    public List<TopicDetailDTO> listTopics(Pageable pageable) {
        return topicRepository.findAll(pageable).map(TopicDetailDTO::new).getContent();
    }

    public TopicDetailDTO updateTopic(Long id, TopicUpdateDTO topicUpdateDTO) {
        Topic topic = topicRepository.getReferenceById(id);
        topic.update(topicUpdateDTO);
        return new TopicDetailDTO(topic);
    }

    public void deleteTopic(Long id) {
        topicRepository.deleteById(id);
    }
}
