import Displays.AdministratorDisplay;
import Displays.DoctorDisplay;
import Examinations.BpExamination;
import Examinations.MriExamination;
import Patient.Patient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Patient patient1 = new Patient("Daphne Von Oram", "https://martinh.netfirms.com/BIOE60010/DaphneVonOram.jpg", 62);
        patient1.addExamination(new MriExamination("https://martinh.netfirms.com/BIOE60010/mri1.jpg", LocalDate.of(2023,9,23), 2));
        patient1.addExamination(new BpExamination(130,70,LocalDate.of(2023,9,15),"ST"));
        DoctorDisplay doctorDisplay1 = new DoctorDisplay(patient1);
        AdministratorDisplay administratorDisplay1 = new AdministratorDisplay(patient1);

        Patient patient2 = new Patient("Sebastian Compton", "https://martinh.netfirms.com/BIOE60010/SebastianCompton.jpg", 31);
        patient2.addExamination(new MriExamination("https://martinh.netfirms.com/BIOE60010/mri2.jpg", LocalDate.of(2023, 11, 19), 4));
        patient2.addExamination(new BpExamination(150, 80, LocalDate.of(2023, 11, 20), "VST"));
        DoctorDisplay doctorDisplay2 = new DoctorDisplay(patient2);
        AdministratorDisplay administratorDisplay2 = new AdministratorDisplay(patient2);

        // Doctor View
        JFrame frameDoc = new JFrame("Doctor Displays.Display");
        frameDoc.setSize(800,600);
        frameDoc.setLayout(new GridLayout(2,1));
        frameDoc.setVisible(true);
        frameDoc.add(doctorDisplay1.getDisplay());
        frameDoc.add(doctorDisplay2.getDisplay());

        frameDoc.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frameDoc.dispose();
            }
        });

        // Administrator View
        JFrame frameAdmin = new JFrame("Administrator Displays.Display");
        frameAdmin.setSize(800,200);
        frameAdmin.setLayout(new GridLayout(2,1));
        frameAdmin.setVisible(true);
        frameAdmin.add(administratorDisplay1.getDisplay());
        frameAdmin.add(administratorDisplay2.getDisplay());

        frameAdmin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frameAdmin.dispose();
            }
        });


    }
}
