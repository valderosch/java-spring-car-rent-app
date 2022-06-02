package com.valderosh.carrent.controllers;
import com.valderosh.carrent.models.Contracts;
import com.valderosh.carrent.models.ParkLot;
import com.valderosh.carrent.repository.ParkLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @Autowired
    private ParkLotRepository parkLotRepository;

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
        Iterable<ParkLot> parks = parkLotRepository.findAll();
        model.addAttribute("parks", parks);
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
