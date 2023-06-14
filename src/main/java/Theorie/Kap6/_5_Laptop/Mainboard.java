package Theorie.Kap6._5_Laptop;

public class Mainboard extends Komponente
{
    private int steckplaetze;
    private Prozessor prozessor;
    private RAM ram;

    public Mainboard(
            String produktNummer
            , String hersteller
            , String modellBezeichnung
            , int steckplaetze
            , Prozessor prozessor
            , RAM ram
    ) {
        super(produktNummer, hersteller, modellBezeichnung);
        this.steckplaetze = steckplaetze;
        this.prozessor = prozessor;
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "  Mainboard: \n" +
                "    Steckplaetze: " + steckplaetze + "\n" +
                "    Prozessor: " + prozessor + "\n" +
                "    RAM: " + ram + "\n";
    }
}
