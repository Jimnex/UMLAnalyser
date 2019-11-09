package parser.metaclasses;

public interface MultiplicityElementParser {
    //boolean parseIsOrdered(); TODO: possible feature
    //boolean parseIsUnique(); TODO: possible feature
    Multiplicity parseMultiplicityBound();
}
