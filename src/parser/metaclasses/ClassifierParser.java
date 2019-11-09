package parser.metaclasses;

import parser.metaclasses.feature.BehavioralFeatureParser;
import parser.metaclasses.feature.StructuralFeatureParser;

import java.util.List;

public interface ClassifierParser extends RedefinableElementParser, NamespaceParser {
    boolean parseIsAbstract();
    List<StructuralFeatureParser> parseStructuralFeatures();
    List<BehavioralFeatureParser> parseBehaviorFeatures();
}
