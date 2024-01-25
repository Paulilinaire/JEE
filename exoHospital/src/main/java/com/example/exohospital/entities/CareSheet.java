package com.example.exohospital.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "care_sheet")
public class CareSheet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String careType;

    private String duration;

    @ManyToOne
    @JoinColumn(name="consultation_id")
    private Consultation consultation;

    public CareSheet(String careType, String duration) {
        this.careType = careType;
        this.duration = duration;
    }
}