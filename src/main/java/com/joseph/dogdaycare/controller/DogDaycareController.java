package com.joseph.dogdaycare.controller;

import com.joseph.dogdaycare.domain.DogDaycareEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.joseph.dogdaycare.service.DogDaycareService;

import java.util.List;

@RequestMapping ("/api")
@RestController
public class DogDaycareController {
    @Autowired
    private DogDaycareService dogDaycareService;

    @GetMapping("/breeds")
    public List<DogDaycareEntry> getAllBreeds () {
        return dogDaycareService.findAllEntries ();
    }

    @GetMapping("/breeds/{id}")
    public DogDaycareEntry findDogDaycareEntryById (@PathVariable("id") Integer id) {
        return this.dogDaycareService.findDogDaycareEntryById (id);
    }

    @GetMapping("/owner/{owner}")
    public List <DogDaycareEntry> findDogDaycareEntryByUser (@PathVariable ("owner") String owner) {
        return this.dogDaycareService.findDogDaycareEntryByOwner (owner);
    }

    @DeleteMapping("/breeds/{id}")
    public void deleteDogDaycareEntryById (@PathVariable ("id") Integer id) {
        this.dogDaycareService.deleteDogDaycareEntryById (id);
    }

    @PostMapping ("/add")
    public void addBreed (@RequestBody DogDaycareEntry dogDaycareEntry) {
        this.dogDaycareService.save (dogDaycareEntry);
    }

    @PostMapping ("/update")
    public void updateBreed (@RequestBody DogDaycareEntry dogDaycareEntry) {
        this.dogDaycareService.save (dogDaycareEntry);
    }



}
