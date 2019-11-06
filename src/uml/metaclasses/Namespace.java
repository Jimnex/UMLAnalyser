package uml.metaclasses;

import java.util.Collection;

public interface Namespace extends NamedElement {
    Collection<NamedElement> getOwnedNamedElements();
}
