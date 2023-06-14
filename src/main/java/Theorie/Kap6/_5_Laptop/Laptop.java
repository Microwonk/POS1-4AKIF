package Theorie.Kap6._5_Laptop;

public class Laptop extends Komponente
{
    private double preis;
    private Gehaeuse gehaeuse;
    private Mainboard mainboard;
    private Bildschirm bildschirm;
    private Festplatte festplatte;

    public Laptop(
            String produktNummer
            , String hersteller
            , String modellBezeichnung
            , double preis
            , Gehaeuse gehaeuse
            , Mainboard mainboard
            , Bildschirm bildschirm
            , Festplatte festplatte
    ) {
        super(produktNummer, hersteller, modellBezeichnung);
        this.preis = preis;
        this.gehaeuse = gehaeuse;
        this.mainboard = mainboard;
        this.bildschirm = bildschirm;
        this.festplatte = festplatte;
    }

    public double getPreis() {
        return preis;
    }

    public void setPreis(double preis) {
        this.preis = preis;
    }

    public Gehaeuse getGehaeuse() {
        return gehaeuse;
    }

    public void setGehaeuse(Gehaeuse gehaeuse) {
        this.gehaeuse = gehaeuse;
    }

    public Mainboard getMainboard() {
        return mainboard;
    }

    public void setMainboard(Mainboard mainboard) {
        this.mainboard = mainboard;
    }

    public Bildschirm getBildschirm() {
        return bildschirm;
    }

    public void setBildschirm(Bildschirm bildschirm) {
        this.bildschirm = bildschirm;
    }

    public Festplatte getFestplatte() {
        return festplatte;
    }

    public void setFestplatte(Festplatte festplatte) {
        this.festplatte = festplatte;
    }

    @Override
    public String toString() {
        return "\nKonfiguration des Laptops: \n" +
                "  Preis: " + preis + " Euro\n" +
                "  ProduktNummer: " + produktNummer + "\n" +
                "  Hersteller: " + hersteller + "\n" +
                "  ModellBezeichnung: " + modellBezeichnung + "\n" +
                   gehaeuse +
                   mainboard +
                   bildschirm +
                   festplatte;
    }
}
