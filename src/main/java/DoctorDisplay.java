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
        mainPanel.setSize(800,300);
        JPanel facePanel = new JPanel();
        facePanel.setSize(200,300);
        JPanel namePanel = new JPanel();
        namePanel.setSize(200,300);
        JPanel mriPanel = new JPanel();
        mriPanel.setSize(200,300);
        JPanel bpPanel = new JPanel();
        bpPanel.setSize(200,300);

        JLabel faceLabel = new JLabel();
        URL actualFaceUrl = null;
        try{
            actualFaceUrl = new URL(urlFace);
        }
        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        ImageIcon faceImage = new ImageIcon(actualFaceUrl);
        faceLabel.setIcon(faceImage);
        facePanel.add(faceLabel);

        String nameMessage = "<html>Name: " + name + "<br>" + "Age: " + age + "</html>";
        JLabel nameLabel = new JLabel(nameMessage);
        namePanel.add(nameLabel);

        JLabel mriLabel = new JLabel();
        URL actualMriUrl = null;
        try{
            actualMriUrl = new URL(urlMRI);
        }
        catch (MalformedURLException e){
            System.out.println(e.getMessage());
        }
        ImageIcon mriImage = new ImageIcon(actualMriUrl);
        mriLabel.setIcon(mriImage);
        mriPanel.add(mriLabel);

        String bpMessage = "<html>Blood pressure<br>" + systolicPressure + " over " + diastolicPressure + "</html>";
        JLabel bpLabel = new JLabel(bpMessage);
        bpPanel.add(bpLabel);

        mainPanel.setLayout(new GridLayout(1,4));
        mainPanel.add(facePanel);
        mainPanel.add(namePanel);
        mainPanel.add(mriPanel);
        mainPanel.add(bpPanel);
        return(mainPanel);
    }
}
