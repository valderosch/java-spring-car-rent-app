package com.valderosh.carrent.controllers;

import com.valderosh.carrent.models.Contracts;
import com.valderosh.carrent.models.InService;
import com.valderosh.carrent.repository.InServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InServiceController {

    @Autowired
    private InServiceRepository inServiceRepository;

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/service")
    public String servicepage(Model model) {
        Iterable<InService> service = inServiceRepository.findAll();
        model.addAttribute("service", service);
        return "inService/inService";
    }
}
