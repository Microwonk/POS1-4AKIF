package Theorie.Kap6._Unterricht_6;

import java.util.Date;

public class Student extends Mensch{
    public String matrikelnummer;

    public Student (String matrikenNr){
        this.matrikelnummer = matrikenNr;
    }

    public Student(String name, Date geburtstag, String matrikelnummer) {
        super(name, geburtstag);
        this.matrikelnummer = matrikelnummer;
    }

    public String getMatrikelnummer () {
        return matrikelnummer;
    }

    public void setMatrikelnummer (String matrikelnummer) {
        this.matrikelnummer = matrikelnummer;
    }

    @Override
    public String toString() {
        return "Student{" +
                "matrikelnummer='" + matrikelnummer + '\'' +
                '}' + super.toString();
    }
}
