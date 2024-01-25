package com.example.exohospital.entities;


import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String lastname;

    private String firstName;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    private byte[] image;

    @OneToMany(mappedBy = "patient")
    private List<Consultation> consultations;

    public Patient(String lastname, String firstName, Date birthDate, byte[] image) {
        this.lastname = lastname;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.image = image;
    }
}
