package com.workintech.s18d2.controller;

import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruit")
public class FruitController {
    private FruitService fruitService;

    @Autowired
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }

    @GetMapping
    public List<Fruit> getAsc(){
        return fruitService.getByPriceAsc();
    }

    @GetMapping("/desc")
    public List<Fruit> getDesc(){
        return fruitService.getByPriceDesc();
    }

    @PostMapping
    public Fruit postFruit(@RequestBody Fruit fruit){
        return fruitService.save(fruit);
    }

    @PostMapping("/name/{name}")
    public List<Fruit> getName(@PathVariable String name){
        return fruitService.searchByName(name);
    }

    @DeleteMapping("/{id}")
    public Fruit deleteFruit(@PathVariable Long id){
        return fruitService.delete(id);
    }



}
