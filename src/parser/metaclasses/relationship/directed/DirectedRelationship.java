package parser.metaclasses.relationship.directed;

import parser.metaclasses.ElementParser;
import parser.metaclasses.relationship.Relationship;

public interface DirectedRelationship<T extends ElementParser> extends Relationship {
    /** A directed relationship is an
     * abstract relationship between
     * a collection of source elements
     * and a collection of tarparse elements. */
}
