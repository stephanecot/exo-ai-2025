package com.example.petmanagement.controller;

import com.example.petmanagement.model.Cat;
import com.example.petmanagement.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cats")
public class CatController {
    
    @Autowired
    private CatService catService;
    
    @PostMapping
    public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
        Cat createdCat = catService.createCat(cat);
        return ResponseEntity.ok(createdCat);
    }
    
    @GetMapping
    public ResponseEntity<List<Cat>> getAllCats() {
        return ResponseEntity.ok(catService.getAllCats());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Cat> getCatById(@PathVariable Long id) {
        Cat cat = catService.getCatById(id);
        return ResponseEntity.ok(cat);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<Cat> getCatByName(@PathVariable String name) {
        return ResponseEntity.ok(catService.getCatByName(name));
    }
    
    @PostMapping("/{id}/pet")
    public ResponseEntity<Cat> petCat(@PathVariable Long id) {
        return ResponseEntity.ok(catService.petCat(id));
    }
    
    @PostMapping("/{id}/feed")
    public ResponseEntity<Cat> feedCat(@PathVariable Long id, @RequestParam String food) {
        return ResponseEntity.ok(catService.feedCat(id, food));
    }
    
    @GetMapping("/{id}/mood")
    public ResponseEntity<String> getCatMood(@PathVariable Long id) {
        return ResponseEntity.ok(catService.getCatMood(id));
    }
    
    @PostMapping("/{id}/magic")
    public ResponseEntity<Cat> useMagicPower(@PathVariable Long id) {
        return ResponseEntity.ok(catService.useMagicPower(id));
    }
    
    @PostMapping("/{id}/napping-spot")
    public ResponseEntity<String> addNappingSpot(@PathVariable Long id, @RequestParam String spot) {
        return ResponseEntity.ok(catService.addNappingSpot(id, spot));
    }
    
    @GetMapping("/mysterious")
    public ResponseEntity<List<Cat>> getMysteriousCats() {
        return ResponseEntity.ok(catService.findMysteriousCats());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Cat> updateCat(@PathVariable Long id, @RequestBody Cat cat) {
        return ResponseEntity.ok(catService.updateCat(id, cat));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCat(@PathVariable Long id) {
        catService.deleteCat(id);
        return ResponseEntity.ok().build();
    }
}
