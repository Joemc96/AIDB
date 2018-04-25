package com.joseph.guestbook.controller;

import com.joseph.guestbook.domain.GuestBookEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.joseph.guestbook.service.GuestBookService;

import java.util.List;

@RequestMapping ("/api")
@RestController
public class GuestBookController {
    @Autowired
    private GuestBookService guestBookService;

    @GetMapping("/comments")
    public List<GuestBookEntry> getAllComments () {
        return guestBookService.findAllEntries ();
    }

    @GetMapping("/comments/{id}")
    public GuestBookEntry findGuestBookEntryById (@PathVariable("id") Integer id) {
        return this.guestBookService.findGuestBookEntryById (id);
    }

    @GetMapping("/user/{user}")
    public List <GuestBookEntry> findGuestBookEntryByUser (@PathVariable ("user") String user) {
        return this.guestBookService.findGuestBookEntryByUser (user);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteGuestBookEntryById (@PathVariable ("id") Integer id) {
        this.guestBookService.deleteGuestBookEntryById (id);
    }

    @PostMapping ("/add")
    public void addComment (@RequestBody GuestBookEntry guestBookEntry) {
        this.guestBookService.save (guestBookEntry);
    }

    @PostMapping ("/update")
    public void updateComment (@RequestBody GuestBookEntry guestBookEntry) {
        this.guestBookService.save (guestBookEntry);
    }



}
