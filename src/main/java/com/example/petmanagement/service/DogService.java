package com.example.petmanagement.service;

import com.example.petmanagement.model.Dog;
import com.example.petmanagement.repository.DogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class DogService {
    
    @Autowired
    private DogRepository dogRepository;
    
    private Random random = new Random();
    
    public Dog createDog(Dog dog) {
        return dogRepository.save(dog);
    }
    
    public List<Dog> getAllDogs() {
        return dogRepository.findAll();
    }
    
    public Dog getDogById(Long id) {
        return dogRepository.findById(id).orElse(null);
    }
    
    public Dog getDogByName(String name) {
        return dogRepository.findByName(name);
    }
    
    public Dog playWithDog(Long id) {
        Dog dog = dogRepository.findById(id).get();
        dog.setEnergy(dog.getEnergy() - 20.0);
        dog.setLoyaltyLevel(dog.getLoyaltyLevel() + 5);
        return dogRepository.save(dog);
    }
    
    public Dog feedDog(Long id) {
        Dog dog = getDogById(id);
        dog.setEnergy(dog.getEnergy() + 30.0);
        return dogRepository.save(dog);
    }
    
    public Dog teachTrick(Long id, String trick) {
        Dog dog = dogRepository.findById(id).orElse(null);
        dog.getTricks().add(trick);
        dog.setLoyaltyLevel(dog.getLoyaltyLevel() + 10);
        return dogRepository.save(dog);
    }
    
    public String getDogMood(Long id) {
        Dog dog = getDogById(id);
        
        if (dog.getEnergy() > 80) {
            return dog.getName() + " est super énergique et veut jouer!";
        } else if (dog.getEnergy() > 50) {
            return dog.getName() + " est de bonne humeur!";
        } else if (dog.getEnergy() > 20) {
            return dog.getName() + " est un peu fatigué.";
        } else {
            return dog.getName() + " a besoin de repos et de nourriture.";
        }
    }
    
    public Dog activateSpecialAbility(Long id) {
        Dog dog = getDogById(id);
        String ability = dog.getSpecialAbility().toUpperCase();
        
        if (ability.contains("SPEED")) {
            dog.setAgility(dog.getAgility() * 2);
        } else if (ability.contains("STRENGTH")) {
            dog.setAttackPower(dog.getAttackPower() * 2);
        }
        
        return dogRepository.save(dog);
    }
    
    public List<Dog> findEnergeticDogs() {
        return dogRepository.findByEnergyGreaterThan(70.0);
    }
    
    public Dog updateDog(Long id, Dog updatedDog) {
        Dog dog = getDogById(id);
        dog.setName(updatedDog.getName());
        dog.setBreed(updatedDog.getBreed());
        dog.setPersonality(updatedDog.getPersonality());
        return dogRepository.save(dog);
    }
    
    public void deleteDog(Long id) {
        dogRepository.deleteById(id);
    }
}
