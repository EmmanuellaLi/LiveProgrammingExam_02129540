package Displays;

import Examinations.BpExamination;
import Examinations.Examination;
import Examinations.MriExamination;
import Patient.Patient;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AdministratorDisplay extends Display{
    public AdministratorDisplay (Patient patient){
        super(patient);
    }

    @Override
    public JPanel getDisplay() {
        // extracting all the required information
        String name = patient.getName();

        int magneticStrength = 0;
        LocalDate mriDate = null;
        String duration = "";
        LocalDate bpDate = null;
        ArrayList<Examination> exams = patient.getExaminations();
        for (Examination e: exams) {
            if (e instanceof MriExamination) {
                magneticStrength = ((MriExamination) e).getMagneticStrength();
                mriDate = e.getDate();
            }
            else if (e instanceof BpExamination) {
                duration = ((BpExamination) e).getDuration();
                bpDate = e.getDate();
            }
        }
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String mriDateString = mriDate.format(pattern);
        String bpDateString = bpDate.format(pattern);

        // creates and formats panel displaying the information
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(800,100);
        String message = "<html>Patient: " + name + ": MRI: " + magneticStrength + " Tesla, " + mriDateString + ": BP: " + duration + ", " + bpDateString + "</html>";
        JLabel label = new JLabel(message);
        mainPanel.add(label);
        return(mainPanel);
    }
}
