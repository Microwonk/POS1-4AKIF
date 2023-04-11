package VALE.CD_DVD;

public class CD extends Medium {

    private String kuenstler;

    static {
        fExtensions = new String[]{".mp3", ".ogg", ".wav"};
    }

    public CD (String typ, String titel, String genre, String kuenstler, int dauer, boolean verliehen) {
        super(typ, titel, genre, dauer, verliehen);
        this.kuenstler = kuenstler;
    }

    public String getKuenstler () {
        return kuenstler;
    }

    public void setKuenstler (String kuenstler) {
        this.kuenstler = kuenstler;
    }

    @Override
    public String toString () {
        return "CD{" +
                "kuenstler='" + kuenstler + '\'' +
                ", typ='" + typ + '\'' +
                ", titel='" + titel + '\'' +
                ", genre='" + genre + '\'' +
                ", dauer=" + dauer +
                ", verliehen=" + verliehen +
                '}';
    }

    @Override
    public String toRawString () {
        return "CD" +
                kuenstler +
                typ +
                titel +
                genre +
                dauer +
                verliehen;
    }
}
