package com.example.petmanagement.repository;

import com.example.petmanagement.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CatRepository extends JpaRepository<Cat, Long> {
    
    List<Cat> findByFurColor(String furColor);
    
    List<Cat> findByPersonality(String personality);
    
    Cat findByName(String name);
    
    List<Cat> findByMysteryPointsGreaterThan(Integer mysteryPoints);
    
    List<Cat> findByAgilityGreaterThan(Integer agility);
}
