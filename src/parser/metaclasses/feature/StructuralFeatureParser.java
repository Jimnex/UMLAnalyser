package parser.metaclasses.feature;

import parser.metaclasses.MultiplicityElementParser;

public interface StructuralFeatureParser extends FeatureParser, MultiplicityElementParser {
    boolean isReadOnly();
}
