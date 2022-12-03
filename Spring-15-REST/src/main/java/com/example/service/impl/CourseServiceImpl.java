package com.example.service.impl;

import com.example.dto.CourseDTO;
import com.example.entity.Course;
import com.example.repository.CourseRepository;
import com.example.service.CourseService;
import com.example.util.MapperUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final MapperUtil mapperUtil;
    private final ModelMapper modelMapper;

    public CourseServiceImpl(CourseRepository courseRepository, MapperUtil mapperUtil, ModelMapper modelMapper) {
        this.courseRepository = courseRepository;
        this.mapperUtil = mapperUtil;
        this.modelMapper = modelMapper;
    }


    @Override
    public CourseDTO createCourse(CourseDTO courseDTO) {
        courseRepository.save(modelMapper.map(courseDTO, Course.class));
        return courseDTO;
    }

    @Override
    public CourseDTO getCourseById(long courseId) {
        return modelMapper.map(courseRepository.findById(courseId),CourseDTO.class);
}

    @Override
    public List<CourseDTO> getCoursesByCategory(String category) {
        List<Course> list = courseRepository.findAllByCategory(category);
       return list.stream().map(course -> modelMapper.map(course,CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public List<CourseDTO> getCourses() {
      //  return  courseRepository.findAll().stream().map(course -> mapperUtil.convert(course,new CourseDTO()) ).collect(Collectors.toList());
          return  courseRepository.findAll().stream().map(course -> modelMapper.map(course,CourseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void updateCourse(Long courseId, CourseDTO courseDTO) {
        Course updatedCourse = modelMapper.map(courseDTO, Course.class);
        courseRepository.findById(courseId).ifPresent(course -> {
            course.setId(courseId);
            course.setCategory(updatedCourse.getCategory());
            course.setDescription(updatedCourse.getDescription());
            course.setName(updatedCourse.getName());
            course.setRating(updatedCourse.getRating());
            courseRepository.save(course);
        });

    }

    @Override
    public void deleteCourseById(long courseId) {
         courseRepository.deleteById(courseId);
    }

    @Override
    public void deleteCourses() {
        courseRepository.deleteAll();

    }
}
