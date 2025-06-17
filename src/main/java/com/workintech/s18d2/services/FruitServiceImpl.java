package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.FruitRepository;
import com.workintech.s18d2.entity.Fruit;
import com.workintech.s18d2.exceptions.PlantException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitServiceImpl implements FruitService{

    private FruitRepository fruitRepository;

    @Autowired
    public FruitServiceImpl(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }


    @Override
    public List<Fruit> getByPriceDesc() {
        return fruitRepository.getByPriceDesc();
    }

    @Override
    public List<Fruit> getByPriceAsc() {
        return fruitRepository.getByPriceAsc();
    }

    @Override
    public List<Fruit> searchByName(String name) {
        return fruitRepository.searchByName(name);
    }

    @Override
    public Fruit getById(Long id) {
        Optional <Fruit> optionalFruit =  fruitRepository.findById(id);
        if(optionalFruit.isPresent()){
            return optionalFruit.get();
        }else if(id < 0){
            throw new PlantException("Id must be bigger then 0" , HttpStatus.BAD_REQUEST);
        }else{
            throw new PlantException("Fruit can not be found. ID: " + id , HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Fruit save(Fruit fruit) {
        if(fruit != null){
            return fruitRepository.save(fruit);
        }else{
            throw new PlantException("Fruit can not be saved " , HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public Fruit delete(Long id) {
        Optional <Fruit> optionalFruit =  fruitRepository.findById(id);
        if(optionalFruit.isPresent()){
            fruitRepository.delete(optionalFruit.get());
            return optionalFruit.get();
        }else if(id < 0){
            throw new PlantException("Id must be bigger then 0" , HttpStatus.BAD_REQUEST);
        }else{
            throw new PlantException("Fruit can not be found. ID: " + id , HttpStatus.NOT_FOUND);
        }
    }
}
