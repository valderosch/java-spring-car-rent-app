package com.valderosh.carrent.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String startpage(Model model) {
        model.addAttribute("title", "Greeting page");
        return "homepage";
    }

    @GetMapping("/main")
    public String homepage(Model model) {
        model.addAttribute("title", "Greeting page");
        return "homepage";
    }

    @GetMapping("/contacts")
    public String contactspage(Model model) {
        model.addAttribute("title", "Contacts");
        return "contacts";
    }

    @GetMapping("/requirements")
    public String requirementspage(Model model) {
        model.addAttribute("title", "Rent requirements");
        return "requirements";
    }

    @GetMapping("/adminpage")
    public String adminpage(Model model) {
        model.addAttribute("title", "Administrator Page");
        return "admin/admin";
    }
}
