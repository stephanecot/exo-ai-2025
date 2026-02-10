package com.example.petmanagement.controller;

import com.example.petmanagement.model.BattleResult;
import com.example.petmanagement.service.BattleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/battles")
public class BattleController {
    
    @Autowired
    private BattleService battleService;
    
    @PostMapping("/dog-vs-dog")
    public ResponseEntity<BattleResult> dogVsDog(
            @RequestParam Long dogId1, 
            @RequestParam Long dogId2) {
        return ResponseEntity.ok(battleService.dogVsDog(dogId1, dogId2));
    }
    
    @PostMapping("/cat-vs-cat")
    public ResponseEntity<BattleResult> catVsCat(
            @RequestParam Long catId1, 
            @RequestParam Long catId2) {
        return ResponseEntity.ok(battleService.catVsCat(catId1, catId2));
    }
    
    @PostMapping("/cat-vs-dog")
    public ResponseEntity<BattleResult> catVsDog(
            @RequestParam Long catId, 
            @RequestParam Long dogId) {
        return ResponseEntity.ok(battleService.catVsDog(catId, dogId));
    }
}
