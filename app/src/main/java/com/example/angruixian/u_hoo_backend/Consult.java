package com.example.angruixian.u_hoo_backend;

import java.io.Serializable;

/**
 * Created by angruixian on 24/2/18.
 */

public class Consult implements Serializable {
    private String patientName;
    private String consultDate;
    private String consultTime;
    private String medicineDetails;
    private String pastHistory;

    public Consult(String patientName, String consultDate, String consultTime, String medicineDetails, String pastHistory) {
        this.patientName = patientName;
        this.consultDate = consultDate;
        this.consultTime = consultTime;
        this.medicineDetails = medicineDetails;
        this.pastHistory = pastHistory;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getConsultDate() {
        return consultDate;
    }

    public void setConsultDate(String consultDate) {
        this.consultDate = consultDate;
    }

    public String getConsultTime() {
        return consultTime;
    }

    public void setConsultTime(String consultTime) {
        this.consultTime = consultTime;
    }

    public String getMedicineDetails() {
        return medicineDetails;
    }

    public void setMedicineDetails(String medicineDetails) {
        this.medicineDetails = medicineDetails;
    }

    public String getPastHistory() {
        return pastHistory;
    }

    public void setPastHistory(String pastHistory) {
        this.pastHistory = pastHistory;
    }

    @Override
    public String toString() {
        return "Patient Name: " + patientName
                + "\nDateTime: " + consultDate + consultTime;
    }
}
