package analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Reporter{
    private final HashMap<String, String> reports;

    public Reporter() {
        this.reports = new HashMap<>();
    }

    public void addReport(String type, String description){
        this.reports.put(type,description);
    }

    public void addReports(HashMap<String, String> externalReports){
        reports.putAll(externalReports);
    }
}
