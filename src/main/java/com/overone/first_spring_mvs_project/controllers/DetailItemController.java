package com.overone.first_spring_mvs_project.controllers;

import com.overone.first_spring_mvs_project.helpers.DetailCar;
import com.overone.first_spring_mvs_project.models.CarModel;
import com.overone.first_spring_mvs_project.models.OrderModel;
import com.overone.first_spring_mvs_project.repos.CarRepo;
import com.overone.first_spring_mvs_project.repos.OrderRepo;
import com.overone.first_spring_mvs_project.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/detailitem")
public class DetailItemController {
    @Autowired
    CarRepo carRepo;

    @Autowired
    CurrencyService currencyService;

    @Autowired
    OrderRepo orderRepo;

    CarModel carModel;

    @GetMapping("/{id}")
    public String getDetailPage(@PathVariable long id,
                                Model model) throws Exception {
        carModel = carRepo.findById(id);
        DetailCar detailCar = new DetailCar();
        detailCar.setCarModel(carModel);
        detailCar.setEurPrice(currencyService.getEURPrice(carModel.getPrice()));
        detailCar.setUsdPrice(currencyService.getUSDPrice(carModel.getPrice()));

        model.addAttribute("car", detailCar);
        return "detailitem";
    }
    @PostMapping
    public RedirectView setOrder(@RequestParam String name,
                                 @RequestParam String number){
        OrderModel orderModel = new OrderModel();
        orderModel.setName(name);
        orderModel.setContact(number);
        orderModel.setCarName(carModel.getName());

        orderRepo.save(orderModel);
        return new RedirectView("/allitems");
    }
}
