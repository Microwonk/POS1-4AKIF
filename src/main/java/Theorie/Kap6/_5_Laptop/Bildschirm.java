package Theorie.Kap6._5_Laptop;

public class Bildschirm
{
    private String aufloesung;

    public Bildschirm(String aufloesung)
    {
        this.aufloesung = aufloesung;
    }

    @Override
    public String toString() {
        return "  Bildschirm: " + "\n" +
                "    Max. Aufloesung: " + aufloesung + '\n';
    }
}
