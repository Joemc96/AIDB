package com.joseph.guestbook.domain;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

@Entity
@Table(name = "GUEST_BOOK_ENTRY")
public class GuestBookEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty
    private String user;
    @NotEmpty
    private String comment;


}

