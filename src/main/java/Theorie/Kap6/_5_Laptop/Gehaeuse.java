package Theorie.Kap6._5_Laptop;

public class Gehaeuse extends Komponente
{
    private String farbe;
    private String material;
    private double breite;
    private double hoehe;
    private double tiefe;

    public Gehaeuse(
            String produktNummer
            , String hersteller
            , String modellBezeichnung
            , String farbe
            , String material
            , double breite
            , double hoehe
            , double tiefe
    ) {
        super(produktNummer, hersteller, modellBezeichnung);
        this.farbe = farbe;
        this.material = material;
        this.breite = breite;
        this.hoehe = hoehe;
        this.tiefe = tiefe;
    }

    @Override
    public String toString() {
        return "  Gehaeuse: \n" +
                "    Farbe: " + farbe + '\n' +
                "    Material: " + material + '\n' +
                "    Abmessung in cm (B/H/T): " + breite + "/" + hoehe + "/" + tiefe + "\n";
    }
}
