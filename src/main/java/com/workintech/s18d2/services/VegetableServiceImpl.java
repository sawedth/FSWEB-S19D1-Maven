package com.workintech.s18d2.services;

import com.workintech.s18d2.repository.VegetableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VegetableServiceImpl implements  VegetableService{

    private VegetableRepository vegetableRepository;
    @Autowired
    public VegetableServiceImpl(VegetableRepository vegetableRepository){
        this.vegetableRepository = vegetableRepository;
    }


}
