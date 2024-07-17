package com.challenges.forum_hub.service;

import com.challenges.forum_hub.dto.CourseDTO;
import com.challenges.forum_hub.entity.Course;
import com.challenges.forum_hub.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public CourseDTO createCourse(CourseDTO courseDTO) {
        Course course = new Course(courseDTO);
        courseRepository.save(course);
        return new CourseDTO(course);
    }

    public List<CourseDTO> listCourses() {
        return courseRepository.findAll().stream().map(CourseDTO::new).collect(Collectors.toList());
    }

    public CourseDTO updateCourse(Long id, CourseDTO courseDTO) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        course.update(courseDTO);
        return new CourseDTO(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}