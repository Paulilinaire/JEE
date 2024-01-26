package com.example.exohospital.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "consultation")
public class Consultation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private Date date;

    private String doctorName;

    @ManyToOne
    @JoinColumn(name="patient_id")
    private Patient patient;


    @OneToMany(mappedBy = "consultation")
    private List<Prescription> prescriptions;


    @OneToMany(mappedBy = "consultation")
    private List<CareSheet> careSheets;

    public Consultation(Date date, String doctorName, Patient patient, List<Prescription> prescriptions, List<CareSheet> careSheets) {
        this.date = date;
        this.doctorName = doctorName;
        this.patient = patient;
        this.prescriptions = prescriptions;
        this.careSheets = careSheets;
    }

    public Consultation(Date date, String doctorName, Patient patient) {
        this.date = date;
        this.doctorName = doctorName;
        this.patient = patient;
    }
}
