package com.company.controller;

import com.company.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {

    @RequestMapping("/welcome")
    public String homepage(Model model){

        model.addAttribute("name","MySchool");
        model.addAttribute("course","MVC");

        String subject="Thymeleaf practice";
        model.addAttribute("subject",subject);

        //create some random studentId(0-1000) and show it in your UI
        int studentId=new Random().nextInt();
        model.addAttribute("id",studentId);


        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(7);
        numbers.add(10);
        model.addAttribute("numbers",numbers);

        Student student=new Student(15,"Alex","Number Ten");
        model.addAttribute("student",student);



        return "/student/welcome";
    }

}
