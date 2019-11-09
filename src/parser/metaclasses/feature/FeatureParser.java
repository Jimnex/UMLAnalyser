package parser.metaclasses.feature;

import parser.metaclasses.RedefinableElementParser;

public interface FeatureParser extends RedefinableElementParser {
    public boolean parseIsStatic();
}
