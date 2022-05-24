package com.valderosh.carrent.controllers;

import com.valderosh.carrent.models.*;
import com.valderosh.carrent.repository.CarsRepository;
import com.valderosh.carrent.repository.ContractsRepository;
import com.valderosh.carrent.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class ContractsController {

    @Autowired
    private ContractsRepository contractsRepository;
    @Autowired
    private CarsRepository carsRepository;
    @Autowired
    private PricesRepository pricesRepository;


    @GetMapping("/contracts")
    public String contractsMainPage(Model model) {
        Iterable<Contracts> contracts = contractsRepository.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts/contracts";
    }

    @GetMapping("/contracts/{id}")
    public String contractsDetailsPage(@PathVariable(value = "id") long id, Model model) {
        if(!contractsRepository.existsById(id)){
            return "redirect:/staff";
        }

        Optional<Contracts> contract = contractsRepository.findById(id);
        ArrayList<Contracts> res = new ArrayList<>();
        contract.ifPresent(res::add);
        model.addAttribute("contract", res);
        return "contracts/contractDetails";
    }



    @GetMapping("/car-park/rent/{id}")
    public String carRentPage(@PathVariable(value = "id") long id, Model model)
    {
        if(!carsRepository.existsById(id)){
            return "redirect:/car-park";
        }
        Optional<Cars> car = carsRepository.findById(id);
        ArrayList<Cars> res = new ArrayList<>();
        car.ifPresent(res::add);
        model.addAttribute("cars", res);
        Iterable<Prices> prices = pricesRepository.findAll();
        model.addAttribute("prices", prices);
        Iterable<Contracts> ctr= contractsRepository.findAll();
        model.addAttribute("contract", ctr);
        return "cars/carRent";
    }

    @PostMapping("/car-park/rent")
    public String newRentRequest(@AuthenticationPrincipal User user,
                              @RequestParam String location,
                              @RequestParam String car,
                              @RequestParam String firstname,
                              @RequestParam String lastname,
                              @RequestParam String phone_number,
                              @RequestParam String passport_data,
                              @RequestParam String age,
                              @RequestParam String driver_exp,
                              @RequestParam String time,
                              @RequestParam String cost,
                              @RequestParam Date created_at,
                              @RequestParam Date expire_date
            ,Model model) {
        Contracts contract = new Contracts(user, location, car, firstname, lastname, phone_number, passport_data, age, driver_exp, time, cost, created_at, expire_date);
        contractsRepository.save(contract);
        return "redirect:/newContract";
    }


    @GetMapping("/newContract")
    public String newContractPage(Model model) {
        Iterable<Contracts> contracts = contractsRepository.findAll();
        model.addAttribute("contracts", contracts);
        return "contracts/newContract";
    }


}
