package com.wipro.mhrs.service;

import java.util.ArrayList;

import com.wipro.mhrs.entity.AllergyRecord;
import com.wipro.mhrs.entity.MedicalRecord;
import com.wipro.mhrs.entity.Patient;
import com.wipro.mhrs.util.PatientNotFoundException;
import com.wipro.mhrs.util.InvalidMedicalRecordException;
import com.wipro.mhrs.util.RecordNotFoundException;

public class MedicalHistoryService {

    ArrayList<Patient> patients;
    ArrayList<MedicalRecord> medicalRecords;
    ArrayList<AllergyRecord> allergyRecords;
    public MedicalHistoryService(ArrayList<Patient> patients,
                                 ArrayList<MedicalRecord> medicalRecords,
                                 ArrayList<AllergyRecord> allergyRecords) {
        this.patients = patients;
        this.medicalRecords = medicalRecords;
        this.allergyRecords = allergyRecords;
    }
    public void addPatient(Patient p) {
        patients.add(p);
    }
    public Patient findPatient(String patientId) throws PatientNotFoundException {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getPatientId().equals(patientId)) {
                return patients.get(i);
            }}
        throw new PatientNotFoundException("Patient not found");
    }
    public void addMedicalRecord(MedicalRecord mr)
            throws PatientNotFoundException, InvalidMedicalRecordException {
        findPatient(mr.getPatientId());
        if (mr.getDiagnosis().equals("")) {
       throw new InvalidMedicalRecordException("Diagnosis empty");
        }

        medicalRecords.add(mr);}
    public void updateMedicalRecord(String recordId,
                                    String newDiagnosis,
                                    String newTreatment,
                                    String newNotes)
            throws RecordNotFoundException {
    	for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getRecordId().equals(recordId)) {    medicalRecords.get(i).setDiagnosis(newDiagnosis);
                medicalRecords.get(i).setTreatment(newTreatment);
                medicalRecords.get(i).setDoctorNotes(newNotes);
                return;
            }
        }
        throw new RecordNotFoundException("Record not found");
    }
    public void addAllergyRecord(AllergyRecord ar)
            throws PatientNotFoundException {

        findPatient(ar.getPatientId());
        allergyRecords.add(ar);
    }
    public ArrayList<MedicalRecord> getMedicalHistory(String patientId)
            throws PatientNotFoundException {
  findPatient(patientId);

        ArrayList<MedicalRecord> list = new ArrayList<>();
        for (int i = 0; i < medicalRecords.size(); i++) {
            if (medicalRecords.get(i).getPatientId().equals(patientId)) {
                list.add(medicalRecords.get(i));
            }
        }
        return list;
    }
    public ArrayList<AllergyRecord> getAllergies(String patientId)
            throws PatientNotFoundException {

        findPatient(patientId);

        ArrayList<AllergyRecord> list = new ArrayList<>();
        for (int i = 0; i < allergyRecords.size(); i++) {
            if (allergyRecords.get(i).getPatientId().equals(patientId)) {
                list.add(allergyRecords.get(i));
            }
        }
        return list;}
    public String generateMedicalSummary(String patientId) {

        try {
            Patient p = findPatient(patientId);
            ArrayList<MedicalRecord> history = getMedicalHistory(patientId);

            String lastDiagnosis = "None";
            if (history.size() > 0) {
                lastDiagnosis = history.get(history.size() - 1).getDiagnosis();
            }

            return "Name: " + p.getName() +
                   "\nAge: " + p.getAge() +
                   "\nGender: " + p.getGender() +
                   "\nRecords Count: " + history.size() +
                   "\nLatest Diagnosis: " + lastDiagnosis;

        } catch (Exception e) {
            return "Error";
        }}}
