package Displays;

import Patient.Patient;
import javax.swing.*;

public abstract class Display {
    protected Patient patient;
    public Display (Patient patient) {
        this.patient = patient;
    }

    public abstract JPanel getDisplay();
}
