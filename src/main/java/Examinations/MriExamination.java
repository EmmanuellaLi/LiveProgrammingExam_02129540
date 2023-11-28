package Examinations;

import java.time.LocalDate;

public class MriExamination extends Examination {
    private final String urlMRI;
    private final int magneticStrength;

    public MriExamination (String url, LocalDate date, int magneticStrength){
        super(date);
        urlMRI = url;
        this.magneticStrength = magneticStrength;
    }

    public String getUrlMRI() {
        return urlMRI;
    }

    public int getMagneticStrength() {
        return magneticStrength;
    }
}
