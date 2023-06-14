package Theorie.Kap6._5_Laptop;

public class Festplatte extends Komponente
{
    Lesekopf lesekopf;
    Schreibkopf schreibkopf;

    public Festplatte(String produktNummer, String hersteller, String modellBezeichnung) {
        super(produktNummer, hersteller, modellBezeichnung);
        this.lesekopf = new Lesekopf();
        this.schreibkopf = new Schreibkopf();
    }

    @Override
    public String toString() {
        return "  Festplatte: " + "\n" +
                "    Lesekopf: " + lesekopf + "\n" +
                "    Schreibkopf: " + schreibkopf;
    }
}
