package Theorie.Kap6._5_Laptop;

public abstract class Komponente
{
    protected String produktNummer;
    protected String hersteller;
    protected String modellBezeichnung;

    public Komponente(String produktNummer, String hersteller, String modellBezeichnung)
    {
        this.produktNummer = produktNummer;
        this.hersteller = hersteller;
        this.modellBezeichnung = modellBezeichnung;
    }

    public String getProduktNummer() {
        return produktNummer;
    }

    public void setProduktNummer(String produktNummer) {
        this.produktNummer = produktNummer;
    }

    public String getHersteller() {
        return hersteller;
    }

    public void setHersteller(String hersteller) {
        this.hersteller = hersteller;
    }

    public String getModellBezeichnung() {
        return modellBezeichnung;
    }

    public void setModellBezeichnung(String modellBezeichnung) {
        this.modellBezeichnung = modellBezeichnung;
    }
}
