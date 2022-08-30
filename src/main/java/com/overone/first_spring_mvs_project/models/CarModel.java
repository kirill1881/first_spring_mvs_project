package com.overone.first_spring_mvs_project.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "car")
public class CarModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "car_name")
    String name;

    @Column(name = "year")
    String year;

    @Column(name = "car_volume")
    String volume;

    @Column(name = "photo_url")
    String url;

    @Column(name = "discription")
    String disc;

    @Column(name = "price")
    int price;
}
