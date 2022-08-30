package com.overone.first_spring_mvs_project.controllers;

import com.overone.first_spring_mvs_project.models.CarModel;
import com.overone.first_spring_mvs_project.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/allitems")
public class AllItemsController {
    @Autowired
    CarRepo carRepo;

    @GetMapping
    public String getAllItems(Model model){
        List<CarModel> carModels = (List<CarModel>) carRepo.findAll();
        model.addAttribute("cars", carModels);
        return "items";
    }
    @PostMapping
    public String getSelectedItems(Model model, @RequestParam int
                                   startPrice, @RequestParam int
                                   endPrice){
        List<CarModel> carModels = (List<CarModel>) carRepo.findAll();
        carModels = carModels.stream().
                filter(c -> c.getPrice()>startPrice&&c.getPrice()<endPrice)
                        .collect(Collectors.toList());
        model.addAttribute("cars", carModels);
        return "items";
    }
}
