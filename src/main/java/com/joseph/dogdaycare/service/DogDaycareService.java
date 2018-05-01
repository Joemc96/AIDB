package com.joseph.dogdaycare.service;

import com.joseph.dogdaycare.domain.DogDaycareEntry;
import com.joseph.dogdaycare.domain.DogDaycareEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DogDaycareService {
    @Autowired

    private DogDaycareEntryRepository dogDaycareEntryRepository;
    public List<DogDaycareEntry> findAllEntries () {
        return this.dogDaycareEntryRepository.findAll ();
    }

    public DogDaycareEntry findDogDaycareEntryById (Integer id) {
        return this.dogDaycareEntryRepository.findDogDaycareEntryById(id);
    }

    public List <DogDaycareEntry> findDogDaycareEntryByOwner (String owner) {
        return this.dogDaycareEntryRepository.findDogDaycareEntryByOwner (owner);
    }

    public void deleteDogDaycareEntryById (Integer id) {
        this.dogDaycareEntryRepository.delete (id);
    }

    public void save (DogDaycareEntry newEntry) {
        this.dogDaycareEntryRepository.save (newEntry);
    }

    public DogDaycareEntry findOne (Integer id) {
        return this.dogDaycareEntryRepository.findOne (id);
    }
}

