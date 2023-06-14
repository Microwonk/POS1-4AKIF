package Theorie.Kap7.Aufg_3;

public class Person {

    private String name;
    private int alter;
    private Geschlecht geschlecht;

    public Person(String name, int alter, Geschlecht geschlecht) {
        this.name = name;
        this.alter = alter;
        this.geschlecht = geschlecht;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlter() {
        return alter;
    }

    public void setAlter(int alter) {
        this.alter = alter;
    }

    public Geschlecht getGeschlecht() {
        return geschlecht;
    }

    public void setGeschlecht(Geschlecht geschlecht) {
        this.geschlecht = geschlecht;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", alter=" + alter +
                ", geschlecht=" + geschlecht +
                '}';
    }

    public enum Geschlecht {
        M,W,D;
    }
}
