package com.joseph.guestbook.controller;

import com.joseph.guestbook.domain.GuestBookEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.joseph.guestbook.service.GuestBookService;

import java.util.List;

@RestController
public class GuestBookController {
    @Autowired
    private GuestBookService guestBookService;

    @GetMapping("/")
    public List<GuestBookEntry> testMapping () {
        return guestBookService.findAllEntries ();
    }



}
