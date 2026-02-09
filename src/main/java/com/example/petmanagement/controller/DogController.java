package com.example.petmanagement.controller;

import com.example.petmanagement.model.Dog;
import com.example.petmanagement.service.DogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dogs")
public class DogController {
    
    @Autowired
    private DogService dogService;
    
    @PostMapping
    public ResponseEntity<Dog> createDog(@RequestBody Dog dog) {
        Dog createdDog = dogService.createDog(dog);
        return ResponseEntity.ok(createdDog);
    }
    
    @GetMapping
    public ResponseEntity<List<Dog>> getAllDogs() {
        return ResponseEntity.ok(dogService.getAllDogs());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Dog> getDogById(@PathVariable Long id) {
        Dog dog = dogService.getDogById(id);
        return ResponseEntity.ok(dog);
    }
    
    @GetMapping("/name/{name}")
    public ResponseEntity<Dog> getDogByName(@PathVariable String name) {
        return ResponseEntity.ok(dogService.getDogByName(name));
    }
    
    @PostMapping("/{id}/play")
    public ResponseEntity<Dog> playWithDog(@PathVariable Long id) {
        return ResponseEntity.ok(dogService.playWithDog(id));
    }
    
    @PostMapping("/{id}/feed")
    public ResponseEntity<Dog> feedDog(@PathVariable Long id) {
        return ResponseEntity.ok(dogService.feedDog(id));
    }
    
    @PostMapping("/{id}/teach")
    public ResponseEntity<Dog> teachTrick(@PathVariable Long id, @RequestParam String trick) {
        return ResponseEntity.ok(dogService.teachTrick(id, trick));
    }
    
    @GetMapping("/{id}/mood")
    public ResponseEntity<String> getDogMood(@PathVariable Long id) {
        return ResponseEntity.ok(dogService.getDogMood(id));
    }
    
    @PostMapping("/{id}/special-ability")
    public ResponseEntity<Dog> activateSpecialAbility(@PathVariable Long id) {
        return ResponseEntity.ok(dogService.activateSpecialAbility(id));
    }
    
    @GetMapping("/energetic")
    public ResponseEntity<List<Dog>> getEnergeticDogs() {
        return ResponseEntity.ok(dogService.findEnergeticDogs());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Dog> updateDog(@PathVariable Long id, @RequestBody Dog dog) {
        return ResponseEntity.ok(dogService.updateDog(id, dog));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDog(@PathVariable Long id) {
        dogService.deleteDog(id);
        return ResponseEntity.ok().build();
    }
}
