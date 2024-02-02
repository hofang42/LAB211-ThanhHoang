/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.HashMap;
import java.util.Map;
import model.DoctorModel;
import utils.Inputter;
import utils.Validation;

/**
 *
 * @author hoang
 */
public class DoctorView {

    Inputter input = new Inputter();
    Validation valid = new Validation();

    public void addDoctor(HashMap<String, DoctorModel> doctorList) {
        boolean flag = true;
        String code = "";
        while (flag) {
            code = input.getStringNotEmpty("Enter Code").toUpperCase();
            if (!valid.isValidCode(code)) {
                System.out.println("You must enter code follow DOC xxx");
            } else if (!valid.isExistCode(doctorList, code)) {
                flag = false;
            } else {
                System.out.println("Doctor is exist");
            }
        }
        String docName = input.getStringNotEmpty("Enter Name");
        String spec = input.getStringNotEmpty("Enter Specialization");
        System.out.print("Enter Availability: ");
        int avai = input.getIntLimit(1, Integer.MAX_VALUE);

        DoctorModel newDoc = new DoctorModel(docName, spec, avai);
        newDoc.setCode(code);
        doctorList.put(code, newDoc);

    }

    public void updateDoctor(HashMap<String, DoctorModel> doctorLists) {
        String code = input.getStringNotEmpty("Enter Code");
        DoctorModel updateDoc = getDoctorByCode(doctorLists, code);
        if (updateDoc == null) {
            System.out.println("No Doctor Found");
        } else {
            String name = input.getString("Enter Name");
            if (name.isEmpty()) {
                name = updateDoc.getName();
            }
            String spec = input.getString("Enter Specialization");
            if (spec.isEmpty()) {
                spec = updateDoc.getSpecialization();
            }
            System.out.print("Enter Availability: ");
            int avai = input.getIntLimit(1, Integer.MAX_VALUE);
            String avaiStr = String.valueOf(avai);
            if (avaiStr.isEmpty()) {
                avai = updateDoc.getAvailalbility();
            }

            updateDoc.setName(name);
            updateDoc.setSpecialization(spec);
            updateDoc.setAvailalbility(avai);
            System.out.println("Update success.");
        }
    }

    public void deleteDoctor(HashMap<String, DoctorModel> doctorLis) {
        String code = input.getStringNotEmpty("Enter code");
        DoctorModel deleteDoc = getDoctorByCode(doctorLis, code);
        if (deleteDoc == null) {
            System.out.println("No Doctor Found");
        } else {
            doctorLis.remove(code.toUpperCase());
        }
    }

    public void searchDoctor(HashMap<String, DoctorModel> doctorList) {
        String text = input.getStringNotEmpty("Enter Text");
        System.out.println("----------- Result ----------");
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                "Specialization", "Availability");
        for (Map.Entry<String, DoctorModel> entry : doctorList.entrySet()) {
            DoctorModel doctor = entry.getValue();
            String code = entry.getKey();
            int avai = parseAvai(text);
            if (doctor.getCode().toLowerCase().contains(text.toLowerCase()) || doctor.getName().toLowerCase().contains(text.toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(text.toLowerCase())) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", code,
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailalbility());
            }
            if ((doctor.getAvailalbility() == avai && avai != -1)) {
                System.out.printf("%-10s%-15s%-25s%-20d\n", code,
                        doctor.getName(), doctor.getSpecialization(),
                        doctor.getAvailalbility());
            }
        }
    }

    public void printAllDoctor(HashMap<String, DoctorModel> doctorList) {
        System.out.printf("%-10s%-15s%-25s%-20s\n", "Code", "Name",
                "Specialization", "Availability");
        for (Map.Entry<String, DoctorModel> entry : doctorList.entrySet()) {
            DoctorModel doctor = entry.getValue();
            String code = entry.getKey();
            System.out.printf("%-10s%-15s%-25s%-20d\n", code,
                    doctor.getName(), doctor.getSpecialization(),
                    doctor.getAvailalbility());
        }
    }

    private DoctorModel getDoctorByCode(HashMap<String, DoctorModel> doctorList, String searchCode) {
        for (Map.Entry<String, DoctorModel> entry : doctorList.entrySet()) {
            DoctorModel doctor = entry.getValue();
            if (doctor.getCode().equalsIgnoreCase(searchCode)) {
                return doctor;
            }
        }
        return null;
    }

    private int parseAvai(String txt) {
        try {
            int avai = Integer.parseInt(txt);
            return avai;
        } catch (Exception e) {
            return -1;
        }
    }
}
