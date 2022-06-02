package com.valderosh.carrent.controllers;
import com.valderosh.carrent.models.*;
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
import java.util.Map;
import java.util.Optional;

@Controller
public class CarsController {

    @Autowired
    private CarsRepository carsRepository;
    @Autowired
    private ParkLotRepository parkLotRepository;


    @GetMapping("/car-park")
    public String carparkpage(@RequestParam(required = false) String filter, Model model) {
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "cars/car-park";
    }


    @GetMapping("/cars-manage")
    public String carsManagePage(Model model) {
        Iterable<Cars> cars = carsRepository.findAll();
        model.addAttribute("cars", cars);
        return "cars/cars-manage";
    }


    @GetMapping("/cars-manage/add")
    public String carsAddpage(Model model) {
        Iterable<ParkLot> park = parkLotRepository.findAll();
        model.addAttribute("parking", park);
        return "cars/carsAdd";
    }

    @PostMapping("/cars-manage/add")
    public String newCarAdd(@RequestParam String brand, @RequestParam  String mark, @RequestParam  String segment, @RequestParam String colour, @RequestParam String power, @RequestParam String drive_opt, @RequestParam String transmission, @RequestParam String fuel, @RequestParam String status, @RequestParam String image, @RequestParam String number, @RequestParam(required = false) Prices prices, @RequestParam(value = "location") ParkLot location, Model model) {
        Cars newCar = new Cars(brand, mark, segment, colour, power, drive_opt, status,  fuel, transmission, image, number, location);
        Long minId = newCar.getId();
        carsRepository.save(newCar);
        return "redirect:/prices-manage";
    }

    @GetMapping("/cars-manage/{id}")
    public String carsDetails(@PathVariable(value = "id") long id, Model model)
    {
        if(!carsRepository.existsById(id)){
            return "redirect:/car-park";
        }

        Optional<Cars> cars = carsRepository.findById(id);
        ArrayList<Cars> res = new ArrayList<>();
        cars.ifPresent(res::add);
        model.addAttribute("cars", res);
        return "cars/carRent";
    }


    @GetMapping("/cars-manage/{id}/edit")
    public String staffEdit(@PathVariable(value = "id") long id, Model model)
    {
        if(!carsRepository.existsById(id)){
            return "redirect:/cars-manage";
        }

        Optional<Cars> car = carsRepository.findById(id);
        ArrayList<Cars> res = new ArrayList<>();
        car.ifPresent(res::add);
        model.addAttribute("car", res);
        Iterable<ParkLot> park = parkLotRepository.findAll();
        model.addAttribute("parking", park);
        return "cars/carsEdit";
    }

    @PostMapping("/cars-manage/{id}/edit")
    public String staffUpdate( @PathVariable(value = "id") long id, @RequestParam String brand, @RequestParam  String mark, @RequestParam  String segment, @RequestParam String colour, @RequestParam String power, @RequestParam String drive_opt, @RequestParam String status, @RequestParam String fuel, @RequestParam String transmission, @RequestParam String image, @RequestParam String number, @RequestParam(required = false) Prices prices, @RequestParam ParkLot location, Model model){
        Cars car = carsRepository.findById(id).orElseThrow();

        car.setBrand(brand);
        car.setMark(mark);
        car.setSegment(segment);
        car.setColour(colour);
        car.setPower(power);
        car.setDrive_opt(drive_opt);
        car.setStatus(status);
        car.setFuel(fuel);
        car.setTransmission(transmission);
        car.setImage(image);
        car.setNumber(number);
//        car.setPrices(prices);
        car.setLocation(location);
        carsRepository.save(car);
        return "redirect:/cars-manage";
    }

    @PostMapping("/cars-manage/{id}/remove")
    public String carDelete( @PathVariable(value = "id") long id, Model model){
        Cars car = carsRepository.findById(id).orElseThrow();
        carsRepository.delete(car);
        return "redirect:/cars-manage";
    }


    @GetMapping("/car-park/details/{id}")
    public String carsDetailsPage(@PathVariable(value = "id") long id, Model model) {
        if(!carsRepository.existsById(id)){
            return "redirect:/staff";
        }

        Optional<Cars> car = carsRepository.findById(id);
        ArrayList<Cars> res = new ArrayList<>();
        car.ifPresent(res::add);
        model.addAttribute("cars", res);
        return "cars/car-details";
    }










    @GetMapping("/contracts/new")
    public String contrAddPage(Model model) {
        Iterable<Cars> contr = carsRepository.findAll();
        model.addAttribute("contracts", contr);
        return "contracts/newContract";
    }
    @GetMapping("/getCar")
    private String finall(Model model){
        return "carGet";
    }
    //    @PostMapping("/car-park/rent/{id}")
//    public String newCarAdd(@PathVariable(value = "id") long id, @RequestParam String car_image, @RequestParam String car_brand, @RequestParam  String car_model, @RequestParam  String car_segment, @RequestParam String car_colour, @RequestParam String car_power, @RequestParam String car_drive_opt, @RequestParam String car_transmission, @RequestParam String car_fuel, @RequestParam String car_status, @RequestParam String min_value_per_hour, Model model) {
//        Cars newCar = new Cars(car_brand, car_model, car_segment, car_colour, car_power, car_drive_opt, car_status,  car_fuel, car_transmission, car_image, min_value_per_hour );
//        carsRepository.save(newCar);
//        return "redirect:/car-park";
//    }




}
