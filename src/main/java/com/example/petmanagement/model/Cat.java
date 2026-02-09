package com.example.petmanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cats")
public class Cat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String furColor;
    private Integer age;
    private Double energy;
    private String personality;
    private String magicPower;
    
    @ElementCollection
    private List<String> favoriteNappingSpots;
    
    private Integer independenceLevel;
    private Integer cunningness;
    private Integer agility;
    private Integer mysteryPoints;
    
    public Cat() {
    }
    
    public Cat(String name, String furColor, Integer age) {
        this.name = name;
        this.furColor = furColor;
        this.age = age;
        this.energy = 80.0;
        this.independenceLevel = 90;
        this.cunningness = 15;
        this.agility = 20;
        this.mysteryPoints = 100;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getFurColor() {
        return furColor;
    }
    
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public Double getEnergy() {
        return energy;
    }
    
    public void setEnergy(Double energy) {
        this.energy = energy;
    }
    
    public String getPersonality() {
        return personality;
    }
    
    public void setPersonality(String personality) {
        this.personality = personality;
    }
    
    public String getMagicPower() {
        return magicPower;
    }
    
    public void setMagicPower(String magicPower) {
        this.magicPower = magicPower;
    }
    
    public List<String> getFavoriteNappingSpots() {
        return favoriteNappingSpots;
    }
    
    public void setFavoriteNappingSpots(List<String> favoriteNappingSpots) {
        this.favoriteNappingSpots = favoriteNappingSpots;
    }
    
    public Integer getIndependenceLevel() {
        return independenceLevel;
    }
    
    public void setIndependenceLevel(Integer independenceLevel) {
        this.independenceLevel = independenceLevel;
    }
    
    public Integer getCunningness() {
        return cunningness;
    }
    
    public void setCunningness(Integer cunningness) {
        this.cunningness = cunningness;
    }
    
    public Integer getAgility() {
        return agility;
    }
    
    public void setAgility(Integer agility) {
        this.agility = agility;
    }
    
    public Integer getMysteryPoints() {
        return mysteryPoints;
    }
    
    public void setMysteryPoints(Integer mysteryPoints) {
        this.mysteryPoints = mysteryPoints;
    }
}
