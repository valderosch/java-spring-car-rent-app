package com.valderosh.carrent.controllers;

import com.valderosh.carrent.models.Roles;
import com.valderosh.carrent.models.User;
import com.valderosh.carrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")
//@PreAuthorize("hasAuthority('ADMIN')")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Roles.values());
        return "userEdit";
    }

    @PostMapping
    public String userSaveChanges(@RequestParam(value = "userId") User user, @RequestParam String username, @RequestParam String password, @RequestParam Map<String, String> form){
        user.setUsername(username);
        user.setPassword(password);

        user.getRoles().clear();

        Set<String> roles = Arrays.stream(Roles.values())
                .map(Roles::name)
                .collect(Collectors.toSet());
        for (String key : form.keySet()){
            if (roles.contains(key)){
                user.getRoles().add(Roles.valueOf(key));
            }
        }



        userRepository.save(user);
        return "redirect:/user";
    }
}
