package analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reporter{
    private final HashMap<String, String> reports;

    public Reporter() {
        this.reports = new HashMap<>();
    }

    public void addReport(String type, String description){
        this.reports.put(type,description);
    }

    public HashMap<String, String> getReports(){
        return new HashMap<String, String>(this.reports);
    }

    public void addReports(Reporter externalReports){
        reports.putAll(externalReports.getReports());
    }

    @Override
    public String toString(){
        String report = "";
        for (Map.Entry<String, String> entry : reports.entrySet()) {
            report += "Konvenció típus: " + entry.getKey() + ", üzenet: " + entry.getValue() + "\n";
        }
        return report;
    }
}
