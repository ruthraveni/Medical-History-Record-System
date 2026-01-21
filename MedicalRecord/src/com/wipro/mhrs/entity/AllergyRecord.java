package com.wipro.mhrs.entity;

public class AllergyRecord {

    private String allergyId;
    private String patientId;
    private String allergyName;
    private String severity;

    public AllergyRecord(String allergyId, String patientId,
                         String allergyName, String severity) {
        this.allergyId = allergyId;
        this.patientId = patientId;
        this.allergyName = allergyName;
        this.severity = severity;
    }

    public String getAllergyId() {
        return allergyId;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public String getSeverity() {
        return severity;
    }
}
