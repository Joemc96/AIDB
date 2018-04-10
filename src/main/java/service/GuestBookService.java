package service;

import domain.GuestBookEntry;
import domain.GuestBookEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestBookService {
    @Autowired

    private GuestBookEntryRepository guestBookEntryRepository;
    public List<GuestBookEntry> findAllEntries () {
        return this.guestBookEntryRepository.findAll ();
    }
}

