package VALE.CD_DVD;

import java.util.ArrayList;
import java.util.List;

public class MedienDB extends ArrayList <Medium> {

    @Override
    public String toString () {
        final StringBuilder builder = new StringBuilder();
        this.forEach(m -> builder.append(m).append('\n'));
        return builder.toString();
    }

    public String CDStoString () {
        final StringBuilder builder = new StringBuilder();

        this.stream()
                .filter(candidate -> candidate instanceof CD)
                .toList()
                .forEach(m -> builder.append(m).append('\n'));

        return builder.toString();
    }

    public String DVDStoString () {
        final StringBuilder builder = new StringBuilder();

        this.stream()
                .filter(candidate -> candidate instanceof DVD)
                .toList()
                .forEach(m -> builder.append(m).append('\n'));

        return builder.toString();
    }

    public String findMedien (String suche) {
        final StringBuilder builder = new StringBuilder();

        this.stream()
                .filter(candidate -> candidate.toRawString().toLowerCase().contains(suche.toLowerCase()))
                .toList()
                .forEach(c -> builder.append(c.toString()).append('\n'));

        return builder.toString();
    }

    public boolean deleteMedien (String suche) {
        if (suche == null
                || this.stream()
                .noneMatch(candidate -> candidate.toRawString().toLowerCase().contains(suche.toLowerCase()))) {
            return false;
        }
        List<Medium> m = this.stream()
                .filter(candidate -> !candidate.toRawString().toLowerCase().contains(suche.toLowerCase()))
                .toList();
        this.clear();
        this.addAll(m);
        return true;
    }
}
