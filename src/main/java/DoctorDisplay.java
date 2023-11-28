import javax.swing.*;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class DoctorDisplay extends Display{
    public DoctorDisplay(Patient patient) {
        super(patient);
    }

    public JPanel getDisplay(){
        // extracting all the information
        String urlFace = patient.getUrlFace();
        String name = patient.getName();
        int age = patient.getAge();

        String urlMRI = null;
        int systolicPressure = 0;
        int diastolicPressure = 0;
        ArrayList<Examination> exams = patient.getExaminations();
        for (Examination e: exams) {
            if (e instanceof MriExamination) {
                urlMRI = ((MriExamination) e).getUrlMRI();
            }
            else if (e instanceof BpExamination) {
                systolicPressure = ((BpExamination) e).getSystolicPressure();
                diastolicPressure = ((BpExamination) e).getDiastolicPressure();
            }
        }

        // displaying the information
        JPanel mainPanel = new JPanel();
        JPanel facePanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel mriPanel = new JPanel();
        JPanel bpPanel = new JPanel();

        JLabel faceLabel = new JLabel();
        ImageIcon faceImage = new ImageIcon(urlFace);
        faceLabel.setIcon(faceImage);
        facePanel.add(faceLabel);

        String nameMessage = "<html>Name: " + name + "<br>" + "Age: " + age + "</html>";
        JLabel nameLabel = new JLabel(nameMessage);
        namePanel.add(nameLabel);

        JLabel mriLabel = new JLabel();
        ImageIcon mriImage = new ImageIcon(urlMRI);
        mriLabel.setIcon(mriImage);
        mriPanel.add(mriLabel);

        String bpMessage = "<html>Blood pressure<br>" + systolicPressure + " over " + diastolicPressure + "</html>";
        JLabel bpLabel = new JLabel(bpMessage);
        bpPanel.add(bpLabel);

        mainPanel.setLayout(new GridLayout(4,1));
        mainPanel.add(facePanel);
        mainPanel.add(namePanel);
        mainPanel.add(mriPanel);
        mainPanel.add(bpPanel);
        return(mainPanel);
    }
}
