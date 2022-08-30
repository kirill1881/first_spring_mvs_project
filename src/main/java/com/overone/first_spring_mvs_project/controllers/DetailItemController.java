package com.overone.first_spring_mvs_project.controllers;

import com.overone.first_spring_mvs_project.models.CarModel;
import com.overone.first_spring_mvs_project.repos.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/detailitem")
public class DetailItemController {
    @Autowired
    CarRepo carRepo;

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id,
                                Model model){
        CarModel carModel = carRepo.findById(id);
        model.addAttribute("car", carModel);
        return "detailitem";
    }
}
