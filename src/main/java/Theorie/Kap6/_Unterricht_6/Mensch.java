package Theorie.Kap6._Unterricht_6;

import java.util.Date;

public class Mensch {
    protected String name;
    protected Date geburtstag;

    public Mensch () {

    }

    public Mensch (String name, Date geburtstag) {
        this.name = name;
        this.geburtstag = geburtstag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGeburtstag() {
        return geburtstag;
    }

    public void setGeburtstag(Date geburtstag) {
        this.geburtstag = geburtstag;
    }

    @Override
    public String toString() {
        return "Mensch{" +
                "name='" + name + '\'' +
                ", geburtstag=" + geburtstag +
                '}';
    }
}
