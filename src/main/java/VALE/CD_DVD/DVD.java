package VALE.CD_DVD;

public class DVD extends Medium {

    private String regisseur;

    static {
        fExtensions = new String[]{".mp4", ".wmv", ".m4v"};
    }

    public DVD (String typ, String titel, String genre, String regisseur, int dauer, boolean verliehen) {
        super(typ, titel, genre, dauer, verliehen);
        this.regisseur = regisseur;
    }

    public String getRegisseur () {
        return regisseur;
    }

    public void setRegisseur (String regisseur) {
        this.regisseur = regisseur;
    }

    @Override
    public String toString () {
        return "DVD{" +
                "regisseur='" + regisseur + '\'' +
                ", typ='" + typ + '\'' +
                ", titel='" + titel + '\'' +
                ", genre='" + genre + '\'' +
                ", dauer=" + dauer +
                ", verliehen=" + verliehen +
                '}';
    }

    @Override
    public String toRawString () {
        return "DVD" +
                regisseur +
                typ +
                titel +
                genre +
                dauer +
                verliehen;
    }
}
