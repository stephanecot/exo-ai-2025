package com.example.petmanagement.service;

import com.example.petmanagement.model.Cat;
import com.example.petmanagement.repository.CatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class CatService {
    
    @Autowired
    private CatRepository catRepository;
    
    private Random random = new Random();
    
    public Cat createCat(Cat cat) {
        return catRepository.save(cat);
    }
    
    public List<Cat> getAllCats() {
        return catRepository.findAll();
    }
    
    public Cat getCatById(Long id) {
        return catRepository.findById(id).orElse(null);
    }
    
    public Cat getCatByName(String name) {
        return catRepository.findByName(name);
    }
    
    public Cat petCat(Long id) {
        Cat cat = catRepository.findById(id).get();
        
        if (cat.getIndependenceLevel() > 80) {
            cat.setEnergy(cat.getEnergy() - 5.0);
            return catRepository.save(cat);
        } else {
            cat.setEnergy(cat.getEnergy() + 10.0);
            return catRepository.save(cat);
        }
    }
    
    public Cat feedCat(Long id, String food) {
        Cat cat = getCatById(id);
        cat.setEnergy(cat.getEnergy() + 25.0);
        cat.setMysteryPoints(cat.getMysteryPoints() + 5);
        return catRepository.save(cat);
    }
    
    public String getCatMood(Long id) {
        Cat cat = getCatById(id);
        String personality = cat.getPersonality();
        
        if (personality.equals("Grumpy")) {
            return cat.getName() + " te regarde avec dédain.";
        } else if (personality.equals("Playful")) {
            return cat.getName() + " veut chasser des jouets!";
        } else {
            return cat.getName() + " est mystérieux comme toujours.";
        }
    }
    
    public Cat useMagicPower(Long id) {
        Cat cat = getCatById(id);
        String magic = cat.getMagicPower();
        
        cat.setMysteryPoints(cat.getMysteryPoints() + random.nextInt(50));
        cat.setEnergy(cat.getEnergy() - 15.0);
        
        return catRepository.save(cat);
    }
    
    public String addNappingSpot(Long id, String spot) {
        Cat cat = catRepository.findById(id).orElse(null);
        cat.getFavoriteNappingSpots().add(spot);
        catRepository.save(cat);
        
        return cat.getName() + " a découvert un nouveau spot: " + spot;
    }
    
    public List<Cat> findMysteriousCats() {
        return catRepository.findByMysteryPointsGreaterThan(80);
    }
    
    public Cat updateCat(Long id, Cat updatedCat) {
        Cat cat = getCatById(id);
        cat.setName(updatedCat.getName());
        cat.setFurColor(updatedCat.getFurColor());
        cat.setPersonality(updatedCat.getPersonality());
        return catRepository.save(cat);
    }
    
    public void deleteCat(Long id) {
        catRepository.deleteById(id);
    }
}
