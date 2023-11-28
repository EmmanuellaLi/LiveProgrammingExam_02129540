import java.time.LocalDate;

public class Examination {
    protected LocalDate date;

    public Examination(LocalDate date){
        this.date = date;
    }

    public LocalDate getDate() {
        return date;
    }
}
