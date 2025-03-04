package com.cognitech.springthymeleafdemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Controller //--- Cannot be @RestController as this is for String specific
public class DemoContoller
{
    @GetMapping("/time")
    public String timeController(Model model)
    {
        model.addAttribute("currentTime", LocalDateTime.now());
        return "time";
    }

    //---------------------------------------------------------------------------------------------
    @GetMapping("/showForm")
    public String showForm()
    {
        return "helloworld-form";
    }

    //---------------------------------------------------------------------------------------------
    @PostMapping("/processForm")
//    public String processForm(HttpServletRequest request, Model model)
//    {
//        String student = request.getParameter("studentName");
//        model.addAttribute("studentName", student.toUpperCase());
//        return "helloworld";
//    }
    public String processForm(@RequestParam String studentName, Model model)
    {
        model.addAttribute("studentName", studentName.toUpperCase());
        return "helloworld";
    }
}
