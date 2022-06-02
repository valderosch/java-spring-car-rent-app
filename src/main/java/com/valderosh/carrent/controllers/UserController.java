package com.valderosh.carrent.controllers;

import com.valderosh.carrent.models.Roles;
import com.valderosh.carrent.models.User;
import com.valderosh.carrent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/user")

public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String userList(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "userList";
    }

//    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("{user}")
    public String userEdit(@PathVariable User user, Model model){
        model.addAttribute("user", user);
        model.addAttribute("roles", Roles.values());
        return "userEdit";
    }

    @PostMapping("{id}")
    public String userSaveChanges(@PathVariable(value = "id") long id, @RequestParam String username, @RequestParam String password, @RequestParam Map<String, String> form){
        User account = userRepository.findById(id).orElseThrow();
        account.setUsername(username);
        account.setPassword(password);

        account.getRoles().clear();

        Set<String> roles = Arrays.stream(Roles.values())
                .map(Roles::name)
                .collect(Collectors.toSet());
        for (String key : form.keySet()){
            if (roles.contains(key)){
                account.getRoles().add(Roles.valueOf(key));
            }

        }

        userRepository.save(account);
        return "redirect:/user";
    }

    @PostMapping("{id}/remove")
    public String staffDelete( @PathVariable(value = "id") long id, Model model){
        User user = userRepository.findById(id).orElseThrow();
        userRepository.delete(user);
        return "redirect:/user";
    }
}
