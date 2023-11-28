package Examinations;

import java.time.LocalDate;

public class BpExamination extends Examination{
    private final int systolicPressure;
    private final int diastolicPressure;
    private final String duration;

    public BpExamination(int systolicPressure, int diastolicPressure, LocalDate date, String duration) {
        super(date);
        this.systolicPressure = systolicPressure;
        this.diastolicPressure = diastolicPressure;
        this.duration = duration;
    }

    public int getSystolicPressure() {
        return systolicPressure;
    }

    public int getDiastolicPressure() {
        return diastolicPressure;
    }

    public String getDuration() {
        return duration;
    }
}
