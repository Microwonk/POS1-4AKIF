package VALE.Warenkorb;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Warenkorb {

    private Map <Produkt, Integer> warenKorbInhalt;

    private Date zuletztAktualisiert;

    public Warenkorb () {
        this.warenKorbInhalt = new HashMap <>();
        this.zuletztAktualisiert = new Date();
    }

    public void addProdukt (Produkt produkt) {
        if (warenKorbInhalt.containsKey(produkt)) {
            this.warenKorbInhalt.replace(produkt, warenKorbInhalt.get(produkt) + 1);
        } else {
            this.warenKorbInhalt.put(produkt, 1);
        }

        this.zuletztAktualisiert.setTime(System.currentTimeMillis());
    }

    public void removeProdukt (int produktnummer) {
        if (this.warenKorbInhalt.keySet().stream().noneMatch(k -> k.getpNr() == produktnummer)) {
            return;
        }
        Produkt p = this.warenKorbInhalt.keySet().stream().filter(k -> k.getpNr() == produktnummer).toList().get(0);
        if (this.warenKorbInhalt.get(p) == 1) {
            this.warenKorbInhalt.remove(p);
            return;
        }
        this.warenKorbInhalt.replace(p , this.warenKorbInhalt.get(p) - 1);
        this.zuletztAktualisiert.setTime(System.currentTimeMillis());
    }

    public Date getZuletztAktualisiert () {
        return zuletztAktualisiert;
    }

    public void setZuletztAktualisiert (Date zuletztAktualisiert) {
        this.zuletztAktualisiert = zuletztAktualisiert;
    }

    public Map <Produkt, Integer> getWarenKorbInhalt () {
        return warenKorbInhalt;
    }

    public void setWarenKorbInhalt (Map <Produkt, Integer> warenKorbInhalt) {
        this.warenKorbInhalt = warenKorbInhalt;
    }

    @Override
    public String toString () {
        return "Warenkorb{" +
                "warenKorbInhalt=" + warenKorbInhalt +
                ", zuletztAktualisiert=" + zuletztAktualisiert +
                '}';
    }
}
