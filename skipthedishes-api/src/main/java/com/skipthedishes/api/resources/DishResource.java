package com.skipthedishes.api.resources;

import com.skipthedishes.api.entities.Dish;
import com.skipthedishes.api.repositories.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishResource {
    
    @Autowired
    private DishRepository dishRepository;

    @PostMapping
    public ResponseEntity<Dish> create(@Valid @RequestBody Dish dish) {
        Dish dishSaved = dishRepository.save(dish);
        return ResponseEntity.status(HttpStatus.CREATED).body(dishSaved);
    }

    @PostMapping(path = "bulk")
    public ResponseEntity<List<Dish>> createBulk(@RequestBody List<Dish> dishList) {
        dishList.stream().forEach(dishRepository::save);
        return ResponseEntity.status(HttpStatus.CREATED).body(dishList);
    }

    @GetMapping
    public ResponseEntity<List<Dish>> findAll() {
        List<Dish> dishList = dishRepository.findAll();
        return dishList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(dishList);
    }

    @GetMapping(path = "{id}", params = "text")
    public ResponseEntity<List<Dish>> find(@PathVariable String id, @RequestParam(name = "text") String text) {
        List<Dish> dishList = dishRepository.find(id, text);
        return dishList.isEmpty() ? ResponseEntity.notFound().build() : ResponseEntity.ok(dishList);
    }
}
