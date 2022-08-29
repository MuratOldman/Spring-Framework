package com.company.controller;

import com.company.enums.Gender;
import com.company.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
@Controller
@RequestMapping("another")
public class AnotherController {
    @RequestMapping("list")
    public String getlist(Model model){
        List<Mentor> mentorList=new ArrayList<>();
        mentorList.add(new Mentor("Mike","Smith", Gender.MALE,45));
        mentorList.add(new Mentor("Tom","Hanks", Gender.MALE,65));
        mentorList.add(new Mentor("Amy","Bryn", Gender.FEMALE,25));
        model.addAttribute("list",mentorList);

        return "mentor/mentor-list";
    }
}
