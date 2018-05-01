package com.joseph.dogdaycare.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DogDaycareEntryRepository
        extends CrudRepository<DogDaycareEntry, Integer> {
    @Override
    List<DogDaycareEntry> findAll ();

    DogDaycareEntry findDogDaycareEntryById (Integer id);

    List<DogDaycareEntry> findDogDaycareEntryByOwner (String owner);
}

