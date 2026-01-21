package com.wipro.mhrs.main;

import java.util.ArrayList;
import com.wipro.mhrs.entity.*;
import com.wipro.mhrs.service.MedicalHistoryService;

public class Main {

    public static void main(String[] args) {

        ArrayList<Patient> patients = new ArrayList<>();
        patients.add(new Patient("P001", "Asha R", 29, "Female"));

        ArrayList<MedicalRecord> medRecords = new ArrayList<>();
        medRecords.add(new MedicalRecord(
                "MR101",
                "P001",
                "2025-02-10",
                "Thyroid imbalance",
                "Thyroxine 50mg daily",
                "Monitor monthly"
        ));

        ArrayList<AllergyRecord> allergyRecords = new ArrayList<>();
        allergyRecords.add(new AllergyRecord(
                "AL001",
                "P001",
                "Pollen",
                "Moderate"
        ));

        MedicalHistoryService service =
                new MedicalHistoryService(patients, medRecords, allergyRecords);

        try {
            MedicalRecord m2 = new MedicalRecord(
                    "MR102",
                    "P001",
                    "2025-06-15",
                    "Migraine episode",
                    "Pain relief medication",
                    "Advise regular sleep"
            );
            service.addMedicalRecord(m2);
            AllergyRecord a2 = new AllergyRecord(
                    "AL002",
                    "P001",
                    "Dust Allergy",
                    "Mild"
            );
            service.addAllergyRecord(a2);
            service.updateMedicalRecord(
                    "MR101",
                    "Thyroid imbalance (Updated)",
                    "Thyroxine 75mg daily",
                    "Increase dosage and continue monitoring"
            );
            System.out.println("--- Medical History ---");
            for (MedicalRecord m : service.getMedicalHistory("P001")) {
                System.out.println(m.getDiagnosis());
            }

            System.out.println("\n--- Medical Summary ---");
            System.out.println(service.generateMedicalSummary("P001"));

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
