package controller;

import domain.GuestBookEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import service.GuestBookService;

import java.util.List;

@RestController
public class GuestBookController {

    @GetMapping("/")
    public List<GuestBookEntry> testMapping () {
        return guestBookService.findAllEntries ();
    }

    @Autowired
    private GuestBookService guestBookService;

}
