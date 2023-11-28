import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        Patient patient1 = new Patient("Daphne Von Oram", "https://martinh.netfirms.com/BIOE60010/DaphneVonOram.jpg", 62);
        patient1.addExamination(new MriExamination("https://martinh.netfirms.com/BIOE60010/mri1.jpg", LocalDate.of(2023,9,28), 2));
        patient1.addExamination(new BpExamination(130,70,LocalDate.of(2023,9,15),"ST"));
        DoctorDisplay doctorDisplay1 = new DoctorDisplay(patient1);
        AdministratorDisplay administratorDisplay1 = new AdministratorDisplay(patient1);

        Patient patient2 = new Patient("Sebastian Compton", "https://martinh.netfirms.com/BIOE60010/SebastianCompton.jpg", 31);
        patient2.addExamination(new MriExamination("https://martinh.netfirms.com/BIOE60010/mri2.jpg", LocalDate.of(2023, 11, 19), 4));
        patient2.addExamination(new BpExamination(150, 80, LocalDate.of(2023, 11, 20), "VST"));
        DoctorDisplay doctorDisplay2 = new DoctorDisplay(patient2);
        AdministratorDisplay administratorDisplay2 = new AdministratorDisplay(patient2);

        JFrame frame = new JFrame("Doctor Display");
        frame.setSize(1000,1000);
        frame.setLayout(new GridLayout(2,1));
        frame.setVisible(true);
        frame.add(doctorDisplay1.getDisplay());
        frame.add(doctorDisplay2.getDisplay());

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }
        });

        JFrame frameDoc = new JFrame("Doctor Display");
        frameDoc.setSize(1000,1000);
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

        JFrame frameAdmin = new JFrame("Administrator Display");
        frameAdmin.setSize(800,400);
        frameAdmin.setLayout(new GridLayout(2,1));
        frameAdmin.setVisible(true);
        frameAdmin.add(administratorDisplay1.getDisplay());
        frameAdmin.add(administratorDisplay2.getDisplay());

        frameAdmin.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frameDoc.dispose();
            }
        });


    }
}
