package com.doctor.care.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reservations_WEB")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "contact_code", nullable = false, length = 50)
    private String contactCode;

    @Column(name = "contact_name", nullable = false, length = 100)
    private String contactName;

    @Column(name = "patient_code", nullable = false, length = 50)
    private String patientCode;

    @Column(name = "patient_name", nullable = false, length = 100)
    private String patientName;

    // ===== Constructors =====
    public Reservation() {
    }

    public Reservation(String contactCode, String contactName,
                       String patientCode, String patientName) {
        this.contactCode = contactCode;
        this.contactName = contactName;
        this.patientCode = patientCode;
        this.patientName = patientName;
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public String getContactCode() {
        return contactCode;
    }

    public void setContactCode(String contactCode) {
        this.contactCode = contactCode;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPatientCode() {
        return patientCode;
    }

    public void setPatientCode(String patientCode) {
        this.patientCode = patientCode;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }
}

