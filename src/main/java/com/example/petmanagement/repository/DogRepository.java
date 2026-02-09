package com.example.petmanagement.repository;

import com.example.petmanagement.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DogRepository extends JpaRepository<Dog, Long> {
    
    List<Dog> findByBreed(String breed);
    
    List<Dog> findByPersonality(String personality);
    
    Dog findByName(String name);
    
    List<Dog> findByEnergyGreaterThan(Double energy);
    
    List<Dog> findByLoyaltyLevelGreaterThan(Integer loyaltyLevel);
}
