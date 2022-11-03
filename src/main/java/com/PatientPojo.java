package com;

import javax.persistence.*;
import java.util.List;
@Entity
public class PatientPojo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private int patientAge;
    private int patientRating;
    private String patientName;
    private String patientDisease;
    private String patientFeedback;

    @ManyToMany(mappedBy = "patientPojos")
    private List<DoctorPojo> doctorPojos;

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientDisease() {
        return patientDisease;
    }

    public void setPatientDisease(String patientDisease) {
        this.patientDisease = patientDisease;
    }

    public String getPatientFeedback() {
        return patientFeedback;
    }

    public void setPatientFeedback(String patientFeedback) {
        this.patientFeedback = patientFeedback;
    }

    public List<DoctorPojo> getDoctorPojos() {
        return doctorPojos;
    }

    public void setDoctorPojos(List<DoctorPojo> doctorPojos) {
        this.doctorPojos = doctorPojos;
    }

    public int getPatientRating() {
        return patientRating;
    }

    public void setPatientRating(int patientRating) {
        this.patientRating = patientRating;
    }

    @Override
    public String toString() {
        return "PatientPojo{" +
                "patientId=" + patientId +
                ", patientAge=" + patientAge +
                ", patientRating=" + patientRating +
                ", patientName='" + patientName + '\'' +
                ", patientDisease='" + patientDisease + '\'' +
                ", patientFeedback='" + patientFeedback + '\'' +
//                ", doctorPojos=" + doctorPojos +
                '}';
    }
}

