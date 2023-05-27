package VALE.Warenkorb;

import java.math.BigDecimal;

public class Produkt {

    protected int pNr;
    protected String pName;
    protected BigDecimal pPreis;
    private static int anzahlInstanzen;

    public Produkt (int pNr, String pName, String pPreis) {
        this.pNr = pNr;
        this.pName = pName;
        this.pPreis = new BigDecimal(pPreis);
    }

    public int getpNr () {
        return pNr;
    }

    public String getpName () {
        return pName;
    }

    public void setpName (String pName) {
        this.pName = pName;
    }

    public BigDecimal getpPreis () {
        return pPreis;
    }

    public void setpPreis (BigDecimal pPreis) {
        this.pPreis = pPreis;
    }

    public String getPreisAsString () {
        return pPreis.toString();
    }

    @Override
    public String toString () {
        return pName + ": " +
                "Nr=" + pNr +
                ", preis=" + pPreis;
    }
}
