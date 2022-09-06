package com.overone.first_spring_mvs_project.helpers;

import com.overone.first_spring_mvs_project.models.CarModel;
import lombok.Data;

@Data
public class DetailCar {
    CarModel carModel;
    double eurPrice;
    double usdPrice;
}
