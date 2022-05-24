package com.valderosh.carrent.controllers;
import com.valderosh.carrent.models.Clients;
import com.valderosh.carrent.repository.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientsController {

    @Autowired
    private ClientsRepository clientsRepository;

    @GetMapping("/clients")
    public String clientspage(Model model) {
        Iterable<Clients> clients = clientsRepository.findAll();
        model.addAttribute("clients", clients);
        return "clients/clients";
    }

}
