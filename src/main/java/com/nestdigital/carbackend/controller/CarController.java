package com.nestdigital.carbackend.controller;

import com.nestdigital.carbackend.dao.CarDao;
import com.nestdigital.carbackend.model.CarModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addCar",consumes = "application/json",produces = "application/json")
    public String carAdd(@RequestBody CarModel car){
        System.out.println(car.toString());
        dao.save(car);
        return "{status:'success'}";
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/viewCar")
    public List<CarModel> viewCar(){
        return (List<CarModel>)
                dao.findAll();
    }

}
