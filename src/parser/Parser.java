package parser;

import java.io.File;
import java.util.*;

public interface Parser<T> {
    T parse();

    String parseName();
}
