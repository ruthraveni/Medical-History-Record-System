package com.wipro.mhrs.entity;

public class MedicalRecord {

    private String recordId;
    private String patientId;
    private String date;
    private String diagnosis;
    private String treatment;
    private String doctorNotes;

    public MedicalRecord(String recordId, String patientId, String date,
                         String diagnosis, String treatment, String doctorNotes) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.date = date;
        this.diagnosis = diagnosis;
        this.treatment = treatment;
        this.doctorNotes = doctorNotes;
    }

    public String getRecordId() {
        return recordId;
    }
    public String getPatientId() {
        return patientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setTreatment(String treatment) {
        this.treatment = treatment;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }
}

