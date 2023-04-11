package VALE.CD_DVD;

public abstract class Medium {

    protected String typ;
    protected String titel;
    protected String genre;
    protected int dauer;
    protected boolean verliehen;
    protected static String[] fExtensions;

    public Medium (String typ, String titel, String genre, int dauer, boolean verliehen) {
        this.typ = typ;
        this.titel = titel;
        this.genre = genre;
        this.dauer = dauer;
        this.verliehen = verliehen;
    }

    public abstract String toRawString();

    public void setTitel (String titel) {
        this.titel = titel;
    }

    public String getTitel () {
        return this.titel;
    }

    public void setGenre (String genre) {
        this.genre = genre;
    }

    public String getGenre () {
        return this.genre;
    }

    public void setDauer (int dauer) {
        this.dauer = dauer;
    }

    public int getDauer () {
        return this.dauer;
    }

    public void setVerliehen (boolean verliehen) {
        this.verliehen = verliehen;
    }

    public boolean isVerliehen () {
        return this.verliehen;
    }

    public void setTyp (String typ) {
        this.typ = typ;
    }

    public String getTyp () {
        return this.typ;
    }
}
