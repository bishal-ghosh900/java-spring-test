package com.example.thymeleafdemo.conrollers;

import com.example.thymeleafdemo.models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {

    @GetMapping("/showForm")
    public String showStudentForm(Model model) {
        model.addAttribute(new Student());
        return "student_form";
    }

    @PostMapping("/processForm")
    public String showStudentInformation(@ModelAttribute("student") Student student) {
        System.out.println(student);
        return "student_information";
    }
}
