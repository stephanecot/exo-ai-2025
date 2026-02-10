package com.example.petmanagement.service;

import com.example.petmanagement.model.BattleResult;
import com.example.petmanagement.model.Cat;
import com.example.petmanagement.model.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BattleService {
    
    @Autowired
    private DogService dogService;
    
    @Autowired
    private CatService catService;
    
    private Random random = new Random();
    
    public BattleResult dogVsDog(Long dogId1, Long dogId2) {
        Dog dog1 = dogService.getDogById(dogId1);
        Dog dog2 = dogService.getDogById(dogId2);
        
        int dog1Power = dog1.getAttackPower() + dog1.getLoyaltyLevel() / 10;
        int dog2Power = dog2.getAttackPower() + dog2.getLoyaltyLevel() / 10;
        
        BattleResult result = new BattleResult();
        
        if (dog1Power > dog2Power) {
            result.setWinner(dog1.getName());
            result.setLoser(dog2.getName());
            result.setDamageDealt(dog1Power - dog2.getDefence());
            result.setBattleDescription(dog1.getName() + " a utilisé " + dog1.getSpecialAbility() + " pour vaincre " + dog2.getName());
        } else {
            result.setWinner(dog2.getName());
            result.setLoser(dog1.getName());
            result.setDamageDealt(dog2Power - dog1.getDefence());
            result.setBattleDescription(dog2.getName() + " a dominé le combat!");
        }
        
        return result;
    }
    
    public BattleResult catVsCat(Long catId1, Long catId2) {
        Cat cat1 = catService.getCatById(catId1);
        Cat cat2 = catService.getCatById(catId2);
        
        int cat1Power = cat1.getCunningness() + cat1.getAgility();
        int cat2Power = cat2.getCunningness() + cat2.getAgility();
        
        cat1Power += cat1.getMysteryPoints() / 10;
        cat2Power += cat2.getMysteryPoints() / 10;
        
        BattleResult result = new BattleResult();
        
        if (cat1Power > cat2Power) {
            result.setWinner(cat1.getName());
            result.setLoser(cat2.getName());
            result.setSpecialMove(cat1.getMagicPower());
            result.setBattleDescription(cat1.getName() + " a utilisé " + cat1.getMagicPower() + " en combat!");
        } else {
            result.setWinner(cat2.getName());
            result.setLoser(cat1.getName());
            result.setSpecialMove(cat2.getMagicPower());
            result.setBattleDescription(cat2.getName() + " était trop rusé!");
        }
        
        return result;
    }
    
    public BattleResult catVsDog(Long catId, Long dogId) {
        Cat cat = catService.getCatById(catId);
        Dog dog = dogService.getDogById(dogId);
        
        int catPower = cat.getAgility() * 2 + cat.getCunningness();
        int dogPower = dog.getAttackPower() + dog.getLoyaltyLevel() / 5;
        
        BattleResult result = new BattleResult();
        result.setDamageDealt(Math.abs(catPower - dogPower));
        
        if (catPower > dogPower) {
            result.setWinner(cat.getName() + " (Chat)");
            result.setLoser(dog.getName() + " (Chien)");
            result.setBattleDescription("Le chat a utilisé son agilité pour esquiver et contre-attaquer!");
            result.setSpecialMove("Griffe mystique");
        } else {
            result.setWinner(dog.getName() + " (Chien)");
            result.setLoser(cat.getName() + " (Chat)");
            result.setBattleDescription("Le chien a dominé grâce à sa loyauté et sa force!");
            result.setSpecialMove("Attaque loyale");
        }
        
        return result;
    }
}
