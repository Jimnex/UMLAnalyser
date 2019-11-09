package parser.metaclasses;

import java.util.Collection;

public interface NamespaceParser extends NamedElementParser {
    Collection<NamedElementParser> parseOwnedNamedElements();
}
