package Theorie.Kap6._Unterricht_6;

import java.util.ArrayList;
import java.util.List;

public class Jahrgang {

    private String stammklasse;
    private List<Student> studenten;

    public Jahrgang () {
        this.studenten = new ArrayList<>();
    }

    public String getStammklasse () {
        return stammklasse;
    }

    public void setStammklasse (String stammklasse) {
        this.stammklasse = stammklasse;
    }

    public List<Student> getStudenten () {
        return studenten;
    }

    public void setStudenten (List<Student> studenten) {
        this.studenten = studenten;
    }

    @Override
    public String toString() {
        return "Jahrgang{" +
                "stammklasse='" + stammklasse + '\'' +
                ", studenten=" + studenten +
                '}';
    }
}
