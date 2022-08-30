package com.overone.first_spring_mvs_project.controllers;

import com.overone.first_spring_mvs_project.models.CarModel;
import com.overone.first_spring_mvs_project.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/additem")
public class AddItemController {
    @Autowired
    CarRepo carRepo;

    @GetMapping
    public String getAddItem(){
        return "additem";
    }
    @PostMapping
    public RedirectView setData(@RequestParam String name,
                                @RequestParam String year,
                                @RequestParam String volume,
                                @RequestParam String url,
                                @RequestParam String disc,
                                @RequestParam int price){
        CarModel carModel = new CarModel();
        carModel.setName(name);
        carModel.setVolume(volume);
        carModel.setYear(year);
        carModel.setUrl(url);
        carModel.setDisc(disc);
        carModel.setPrice(price);

        carRepo.save(carModel);
        return new RedirectView("/");
    }
}
