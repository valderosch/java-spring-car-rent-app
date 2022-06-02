package com.valderosh.carrent.controllers;

import com.valderosh.carrent.models.Cars;
import com.valderosh.carrent.models.Prices;
import com.valderosh.carrent.models.Staff;
import com.valderosh.carrent.repository.CarsRepository;
import com.valderosh.carrent.repository.PricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class PricesController {

    @Autowired
    private PricesRepository pricesRepository;
    @Autowired
    private CarsRepository carsRepository;


    @GetMapping("/prices")
    public String pricespage(Model model) {
        Iterable<Prices> prices = pricesRepository.findAll();
        model.addAttribute("prices", prices);
        return "prices/prices";
    }

    @GetMapping("/prices-manage")
    public String pricesManagePage(Model model) {
        Iterable<Prices> prices = pricesRepository.findAll();
        model.addAttribute("prices", prices);
        return "prices/prices-manage";
    }

    //@RequestParam Cars cars,
    @GetMapping("/prices-manage/add")
    public String priceAddpage( Model model) {
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "prices/priceAdd";
    }


    @PostMapping("/prices-manage/add")
    public String newPriceAdd(@RequestParam Cars cars, @RequestParam int per_hour, @RequestParam  int one_day, @RequestParam  int seven_days, @RequestParam int thirty_days, Model model) {
        Prices newPrice = new Prices(cars, per_hour, one_day, seven_days, thirty_days);
        pricesRepository.save(newPrice);
        return "redirect:/prices";
    }

    @GetMapping("/prices-manage/{id}/edit")
    public String priceEdit(@PathVariable(value = "id") long id, Model model)
    {
        if(!pricesRepository.existsById(id)){
            return "redirect:/prices-manage";
        }

        Optional<Prices> price = pricesRepository.findById(id);
        ArrayList<Prices> res = new ArrayList<>();
        price.ifPresent(res::add);
        model.addAttribute("price", res);
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "prices/priceEdit";
    }

    @PostMapping("/prices-manage/{id}/edit")
    public String pricesUpdate( @PathVariable(value = "id") long id, @RequestParam Cars cars, @RequestParam int per_hour, @RequestParam  int one_day, @RequestParam  int seven_days, @RequestParam int thirty_days, Model model){
        Prices price = pricesRepository.findById(id).orElseThrow();
        price.setCars(cars);
        price.setPer_hour(per_hour);
        price.setOne_day(one_day);
        price.setSeven_days(seven_days);
        price.setThirty_days(thirty_days);

        pricesRepository.save(price);
        return "redirect:/prices-manage";
    }

    @PostMapping("/prices-manage/{id}/remove")
    public String priceDelete( @PathVariable(value = "id") long id, Model model){
        Prices price = pricesRepository.findById(id).orElseThrow();
        pricesRepository.delete(price);
        return "redirect:/prices-manage";
    }
}
