package com.valderosh.carrent.controllers;
import com.valderosh.carrent.models.Clients;
import com.valderosh.carrent.models.Staff;
import com.valderosh.carrent.repository.StaffRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class StaffController {

    @Autowired
    private StaffRepository staffRepository;

    @GetMapping("/staff")
    public String staffPage(Model model) {
        Iterable<Staff> staff = staffRepository.findAll();
        model.addAttribute("staff", staff);
        return "staff/staff";
    }

    @GetMapping("/staff/add")
    public String staffAddPage(Model model) {
        return "staff/staffAdd";
    }

    @PostMapping("/staff/add")
    public String employeePAdd(@RequestParam String firstname, @RequestParam  String lastname, @RequestParam  String role, @RequestParam String phone_number, @RequestParam String status, Model model){
        Staff staffobj = new Staff(firstname, lastname, role, phone_number, status );
        staffRepository.save(staffobj);
        return "redirect:/staff";
    }

    @GetMapping("/staff/{id}")
    public String employeeDetails(@PathVariable(value = "id") long id, Model model)
    {
        if(!staffRepository.existsById(id)){
            return "redirect:/staff";
        }

        Optional<Staff> employee = staffRepository.findById(id);
        ArrayList<Staff> res = new ArrayList<>();
        employee.ifPresent(res::add);
        model.addAttribute("staff", res);
        return "staff/employeeDetails";
    }

    @GetMapping("/staff/{id}/edit")
    public String staffEdit(@PathVariable(value = "id") long id, Model model)
    {
        if(!staffRepository.existsById(id)){
            return "redirect:/staff";
        }

        Optional<Staff> employee = staffRepository.findById(id);
        ArrayList<Staff> res = new ArrayList<>();
        employee.ifPresent(res::add);
        model.addAttribute("staff", res);
        return "staff/staffEdit";
    }

    @PostMapping("/staff/{id}/edit")
    public String staffUpdate( @PathVariable(value = "id") long id, @RequestParam String firstname, @RequestParam  String lastname, @RequestParam  String role, @RequestParam String phone_number, @RequestParam String status, Model model){
        Staff employee = staffRepository.findById(id).orElseThrow();
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setRole(role);
        employee.setPhone_number(phone_number);
        employee.setStatus(status);
        staffRepository.save(employee);
        return "redirect:/staff";
    }

    @PostMapping("/staff/{id}/remove")
    public String staffDelete( @PathVariable(value = "id") long id, Model model){
        Staff staff = staffRepository.findById(id).orElseThrow();
        staffRepository.delete(staff);
        return "redirect:/staff";
    }
}
