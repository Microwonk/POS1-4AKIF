package VALE.Warenkorb;

import java.util.HashSet;
import java.util.Set;

public class NahrungsmittelProdukt extends Produkt{

    private final Set<Allergen> allergene;

    public NahrungsmittelProdukt (int pNr, String pName, String pPreis, HashSet<Allergen> allergene) {
        super(pNr, pName, pPreis);
        this.allergene = new HashSet <>(allergene);
    }

    @Override
    public String toString () {
        return super.toString() + ", Allergene=" + allergene.toString();
    }

    public enum Allergen {
        A,
        B,
        C,
        D,
        E,
        F;
    }
}
