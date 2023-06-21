package com.example.demo.user.controller;

import com.example.demo.user.repository.UserRepository;
import com.example.demo.entity.ums.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserAuthenticationController {

    private final UserRepository userRepository;

    public UserAuthenticationController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/home")
    public String mainPage(Model model){
        List<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/home/add")
    public String formPage(Model model){
        User user=new User();
        model.addAttribute("user", user);
        return "users_form";
    }

    @PostMapping("/home/save")
    public String formSavePage(User user, Model model){
        User save = userRepository.save(user);
        model.addAttribute("save", save);
        return "redirect:/home";
    }
}
