package com.example.exohospital.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String medicine;

    private String duration;

    @ManyToOne
    @JoinColumn(name="consultation_id")
    private Consultation consultation;

    public Prescription(String medicine, String duration) {
        this.medicine = medicine;
        this.duration = duration;
    }
}
