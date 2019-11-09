package parser.metaclasses;

import java.util.Objects;

public class Multiplicity {
    private String lowerBound;
    private String upperBound;

    public Multiplicity(String lowerBound, String upperBound) {
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Multiplicity that = (Multiplicity) o;
        return lowerBound.equals(that.lowerBound) &&
                upperBound.equals(that.upperBound);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lowerBound, upperBound);
    }
}
