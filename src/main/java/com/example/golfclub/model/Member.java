package com.example.golfclub.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String phoneNumber;
    private String startDate;
    private int membershipDuration; // Months for ex

    //Default start (JPA)
    public Member() {}

    // Parameters
    public Member(String name, String address, String email, String phoneNumber, String startDate, int membershipDuration) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.startDate = startDate;
        this.membershipDuration = membershipDuration;
    }

    // Get / Set things
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
