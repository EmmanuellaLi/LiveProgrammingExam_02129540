import jdk.vm.ci.meta.Local;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class AdministratorDisplay extends Display{
    public AdministratorDisplay (Patient patient){
        super(patient);
    }

    @Override
    public JPanel getDisplay() {
        // extracting all the information
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

        // Display Information
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(400,200);
        String message = "<html>Patient: " + name + ": MRI: " + magneticStrength + " Tesla, " + mriDate.toString() + ": BP: " + duration + ", " + bpDate.toString() + "</html>";
        JLabel label = new JLabel(message);
        mainPanel.add(label);
        return(mainPanel);
    }
}
