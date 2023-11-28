import java.util.ArrayList;

public class Patient {
    private final String name;
    private final String urlFace;
    private final int age;
    private ArrayList<Examination> examinations = new ArrayList<>();

    public Patient (String name, String url, int age) {
        this.name = name;
        urlFace = url;
        this.age = age;
    }

    public void addExamination (Examination e) {
        examinations.add(e);
    }
}
