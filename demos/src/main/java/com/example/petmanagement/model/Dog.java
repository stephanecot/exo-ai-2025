package com.example.petmanagement.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "dogs")
public class Dog {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String breed;
    private Integer age;
    private Double energy;
    private String personality;
    private String specialAbility;
    
    @ElementCollection
    private List<String> favoriteToys;
    
    @ElementCollection
    private List<String> tricks;
    
    private Integer loyaltyLevel;
    private Integer attackPower;
    private Integer defence;
    
    public Dog() {
    }
    
    public Dog(String name, String breed, Integer age) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.energy = 100.0;
        this.loyaltyLevel = 50;
        this.attackPower = 10;
        this.defence = 10;
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
    
    public String getBreed() {
        return breed;
    }
    
    public void setBreed(String breed) {
        this.breed = breed;
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
    
    public String getSpecialAbility() {
        return specialAbility;
    }
    
    public void setSpecialAbility(String specialAbility) {
        this.specialAbility = specialAbility;
    }
    
    public List<String> getFavoriteToys() {
        return favoriteToys;
    }
    
    public void setFavoriteToys(List<String> favoriteToys) {
        this.favoriteToys = favoriteToys;
    }
    
    public List<String> getTricks() {
        return tricks;
    }
    
    public void setTricks(List<String> tricks) {
        this.tricks = tricks;
    }
    
    public Integer getLoyaltyLevel() {
        return loyaltyLevel;
    }
    
    public void setLoyaltyLevel(Integer loyaltyLevel) {
        this.loyaltyLevel = loyaltyLevel;
    }
    
    public Integer getAttackPower() {
        return attackPower;
    }
    
    public void setAttackPower(Integer attackPower) {
        this.attackPower = attackPower;
    }
    
    public Integer getDefence() {
        return defence;
    }
    
    public void setDefence(Integer defence) {
        this.defence = defence;
    }
}
