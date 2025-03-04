package com.cognitech.springthymeleafdemo.controller;

import com.cognitech.springthymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController
{
    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${osystems}")
    private List<String> osystems;

    @GetMapping("/student")
    public String showStudentForm(Model model)
    {
        Student student = new Student("", "", "", "", null);
        model.addAttribute("student", student);
        model.addAttribute("countries", countries);
        model.addAttribute("languages", languages);
        model.addAttribute("osystems", osystems);
        return "studentForm";
    }

    //---------------------------------------------------------------------------------------------
    @PostMapping("/processStudentForm")
    public String processStudentForm(@ModelAttribute("student") Student student)
    {
        System.out.println("Got student " + student.toString());

        return "studentConfirmation";
    }
}
