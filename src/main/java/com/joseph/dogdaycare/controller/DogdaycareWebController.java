package com.joseph.dogdaycare.controller;

import com.joseph.dogdaycare.domain.DogDaycareEntry;
import com.joseph.dogdaycare.service.DogDaycareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;


@Controller
public class DogdaycareWebController {
    private static final String DOGDAYCARE_TEMPLATE = "dogdaycare";
    private static final String ENTRIES_TEMPLATE_ID = "entries";
    private static final String HOMEPAGE_REDIRECT = "redirect:/";
    private static final String NEW_ENTRY_TEMPLATE_ID = "newEntry";
    private static final String DOGDAYCARE_FORM_HEADER_ID = "formHeader";

    @Autowired
    private DogDaycareService dogDaycareService;



    @GetMapping ("/")
    public String displayDogDaycare (Model model) {
        model.addAttribute (DOGDAYCARE_FORM_HEADER_ID, "Add a New Dog");
        model.addAttribute(ENTRIES_TEMPLATE_ID, this.dogDaycareService.findAllEntries());
        model.addAttribute (NEW_ENTRY_TEMPLATE_ID, new DogDaycareEntry());
        return DOGDAYCARE_TEMPLATE;
    }

    @GetMapping ("/delete/{id}")
    public String deleteBreed (@PathVariable Integer id) {
        this.dogDaycareService.deleteDogDaycareEntryById (id);
        return HOMEPAGE_REDIRECT;
    }

    @PostMapping("/")
    public String addBreed (Model model, @Valid @ModelAttribute(NEW_ENTRY_TEMPLATE_ID) DogDaycareEntry newEntry, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            this.dogDaycareService.save(newEntry);
            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute (DOGDAYCARE_FORM_HEADER_ID, "Please Correct the Dog Breed");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.dogDaycareService.findAllEntries());
            return DOGDAYCARE_TEMPLATE;
        }
    }

    @GetMapping ("update/{id}")
    public String editBreed (Model model, @PathVariable Integer id) {
        model.addAttribute (ENTRIES_TEMPLATE_ID, this.dogDaycareService.findAllEntries ());
        model.addAttribute (DOGDAYCARE_FORM_HEADER_ID, "Please Change the Dog Breed");
        model.addAttribute (NEW_ENTRY_TEMPLATE_ID, this.dogDaycareService.findOne (id));
        return DOGDAYCARE_TEMPLATE;
    }

    @PostMapping ("update/{id}")
    public String saveBreed (Model model, @PathVariable Integer id, @Valid @ModelAttribute (NEW_ENTRY_TEMPLATE_ID) DogDaycareEntry newEntry, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            DogDaycareEntry current = this.dogDaycareService.findOne(id);
            current.setOwner(newEntry.getOwner());
            current.setBreed(newEntry.getBreed());
            current.setDate(newEntry.getDate());
            this.dogDaycareService.save(current);
            return HOMEPAGE_REDIRECT;
        } else {
            model.addAttribute(DOGDAYCARE_FORM_HEADER_ID, "Please Correct the Dog Breed");
            model.addAttribute(ENTRIES_TEMPLATE_ID, this.dogDaycareService.findAllEntries());
            return DOGDAYCARE_TEMPLATE;
        }
    }

    @GetMapping("/owner/{owner}")
    public List<DogDaycareEntry> findDogDaycareEntryByUser (@PathVariable ("owner") String owner) {
        return this.dogDaycareService.findDogDaycareEntryByOwner (owner);
    }

    }
