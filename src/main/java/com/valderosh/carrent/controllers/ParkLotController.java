package com.valderosh.carrent.controllers;

import com.valderosh.carrent.models.Cars;
import com.valderosh.carrent.models.ParkLot;
import com.valderosh.carrent.models.Staff;
import com.valderosh.carrent.repository.CarsRepository;
import com.valderosh.carrent.repository.ParkLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class ParkLotController {

    @Autowired
    private ParkLotRepository parkLotRepository;
    @Autowired
    private CarsRepository carsRepository;


    @GetMapping("/parking")
    public String parkingpage(Model model) {
        Iterable<ParkLot> parking = parkLotRepository.findAll();
        model.addAttribute("parking", parking);
        return "parking/parking";
    }

    @GetMapping("/parking/add")
    public String parkingAddPage(Model model) {
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "parking/parkAdd";
    }

    @PostMapping("/parking/add")
    public String parkingPostAdd(@RequestParam String location, @RequestParam String autos ,@RequestParam(required = false)  String avaliable, @RequestParam(required = false) String unavaliable, @RequestParam int number_of_cars, Model model){
//         @RequestParam(value = "selected", required = false) String selected,
//        String[] stringArray = selected.split(",");
//        List<String> autos = Arrays.asList(stringArray);
        ParkLot parking = new ParkLot(location, autos, avaliable, unavaliable, number_of_cars );
        parkLotRepository.save(parking);
        return "redirect:/parking";
    }

    @GetMapping("/parking/{id}/edit")
    public String parkEdit(@PathVariable(value = "id") long id, Model model)
    {
        if(!parkLotRepository.existsById(id)){
            return "redirect:/parking";
        }

        Optional<ParkLot> park = parkLotRepository.findById(id);
        ArrayList<ParkLot> res = new ArrayList<>();
        park.ifPresent(res::add);
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        model.addAttribute("parking", res);
        return "parking/parkEdit";
    }

    @PostMapping("/parking/{id}/edit")
    public String parkUpdate( @PathVariable(value = "id") long id, @RequestParam String location, @RequestParam String autos ,@RequestParam(required = false)  String avaliable, @RequestParam(required = false) String unavaliable, @RequestParam int number_of_cars, Model model){
        ParkLot park = parkLotRepository.findById(id).orElseThrow();
        park.setLocation(location);
        park.setAutos(autos);
        park.setAvaliable(avaliable);
        park.setUnavaliable(unavaliable);
        park.setNumber_of_cars(number_of_cars);
        parkLotRepository.save(park);
        return "redirect:/parking";
    }

    @PostMapping("/parking/{id}/remove")
    public String  ParkDelete( @PathVariable(value = "id") long id, Model model){
        ParkLot park = parkLotRepository.findById(id).orElseThrow();
        parkLotRepository.delete(park);
        return "redirect:/parking";
    }
}
