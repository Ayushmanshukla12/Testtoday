package com;

import javax.persistence.*;
import java.util.List;
@Entity
public class DoctorPojo {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int doctorId;
    private int doctorExperience;
    private int doctorFees;
    private String doctorSpecialization;
    private String doctorName;
    @ManyToMany
    private List<PatientPojo> patientPojos;

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public int getDoctorExperience() {
        return doctorExperience;
    }

    public void setDoctorExperience(int doctorExperience) {
        this.doctorExperience = doctorExperience;
    }

    public int getDoctorFees() {
        return doctorFees;
    }

    public void setDoctorFees(int doctorFees) {
        this.doctorFees = doctorFees;
    }

    public String getDoctorSpecialization() {
        return doctorSpecialization;
    }

    public void setDoctorSpecialization(String doctorSpecialization) {
        this.doctorSpecialization = doctorSpecialization;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public List<PatientPojo> getPatientPojos() {
        return patientPojos;
    }

    public void setPatientPojos(List<PatientPojo> patientPojos) {
        this.patientPojos = patientPojos;
    }

    @Override
    public String toString() {
        return "DoctorPojo{" +
                "doctorId=" + doctorId +
                ", doctorExperience=" + doctorExperience +
                ", doctorFees=" + doctorFees +
                ", doctorSpecialization='" + doctorSpecialization + '\'' +
                ", doctorName='" + doctorName + '\'' +
                ", patientPojos=" + patientPojos +
                '}';
    }
}