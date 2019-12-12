package analyser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Reporter{
    private final List<Report> reports;

    public Reporter() {
        this.reports = new ArrayList<>();
    }

    public void addReport(String id, String description){
        this.reports.add(new Report(id,description));
    }

    public List<Report> getReports(){
        return new ArrayList<Report>(this.reports);
    }

    public void addReports(Reporter reporter){
        if(reporter != null){
            reports.addAll(reporter.getReports());
        }
    }

    public class Report{
        private final String conventionType;
        private final String description;

        public Report(String conventionType, String description) {
            this.conventionType = conventionType;
            this.description = description;
        }

        public String getConventionType() {
            return conventionType;
        }

        public String getDescription() {
            return description;
        }
    }
}
