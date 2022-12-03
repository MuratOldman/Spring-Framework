package com.example.controller;

import com.example.dto.CourseDTO;
import com.example.service.CourseService;
import org.hibernate.query.QueryParameter;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.List;

@RequestMapping("/courses")
@RestController // @Controller + @ResponseBody
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("/{id}")
    public CourseDTO getCourseByID(@PathVariable Long id){
        return courseService.getCourseById(id);
    }

    @GetMapping("/category/{name}")
    public List<CourseDTO> getAllCoursesByCategory(@PathVariable("name") String category){
        return courseService.getCoursesByCategory(category);
    }

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO courseDTO){
       return courseService.createCourse(courseDTO);
    }
    @PutMapping("{id}")
    public void updateCourse(@PathVariable Long id,@RequestBody CourseDTO courseDTO){
        courseService.updateCourse(id,courseDTO);
    }

    @DeleteMapping("{id}")
    public void deleteCourse(@PathVariable Long id){
        courseService.deleteCourseById(id);
    }

    @DeleteMapping
    public void deleteAllCourses(){
        courseService.deleteCourses();
    }

}
