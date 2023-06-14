package Theorie.Kap6._Unterricht_6;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Lehrer extends Mensch {
    private List <Student> unterrichtet;
    private List <String> faecher;

    public Lehrer () {
        this("", new Date());
    }

    public Lehrer(String name, Date geburtstag) {
        super(name, geburtstag);
        this.unterrichtet = new ArrayList<>();
        this.faecher = new ArrayList<>();
    }

    public List<Student> getUnterrichtet () {
        return unterrichtet;
    }

    public void setUnterrichtet (List<Student> unterrichtet) {
        this.unterrichtet = unterrichtet;
    }

    public List<String> getFaecher() {
        return faecher;
    }

    public void setFaecher(List<String> faecher) {
        this.faecher = faecher;
    }

    @Override
    public String toString() {
        return "Lehrer{" +
                "unterrichtet=" + unterrichtet +
                ", faecher=" + faecher +
                '}'+ super.toString();
    }
}
