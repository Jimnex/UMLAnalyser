import analyser.Analyser;
import analyser.Reporter;
import factory.AnalysersFactory;
import factory.ClassDiagramAnalysersFactory;
import factory.DiagramFactory;
import uml.diagrams.Diagram;
import uml.diagrams.umlclass.ClassDiagramStructure;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;
import java.util.List;


public class MainForm {
    private JButton parseButton;
    private JButton analyseButton;
    private JPanel mainPanel;
    private JPanel buttonsPanel;
    private JButton parseBtn;
    private JButton analyseBtn;
    private JCheckBox upperCaseNamingCb;
    private JCheckBox atLeastOneAttributeOrBehaviore;
    private JCheckBox NoCommonAttributeOrBehavireWithSuper;
    private JCheckBox InterfaceOnlyPublic;
    private JCheckBox InterfaceContainsAttribute;
    private JCheckBox InterfaceContainsOnlyStaticAttributes;
    private JCheckBox InterfaceHasPublicScope;
    private JPanel analyseConventionsPanel;
    private JCheckBox interfaceOrAbstractClassHasAtLeastOneDerived;
    private JCheckBox ALLCheckEvent;
    private List<File> files;
    private DiagramFactory diagramFactory;
    private List<Diagram> diagrams;
    private List<String> conventions = new ArrayList<>();
    private String parseMessage = "";



    public MainForm() {
        analyseBtn.setEnabled(false);
        analyseConventionsPanel.setVisible(false);
        ALLCheckEvent.setVisible(false);

        parseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                files = new ArrayList<>();
                diagrams = new ArrayList<>();
                parseMessage = "";
                fileHandling();
                diagramCreating();
                diagramParsing();
                handleUserMessageAfterParse();
                setEnableGUIAfterParsing();
            }

            private void fileHandling(){
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fileChooser.showOpenDialog(buttonsPanel);
                File probableFile = fileChooser.getSelectedFile();

                if(probableFile.isFile()) {
                    handleSingleFile(probableFile);
                } else if(probableFile.isDirectory()) {
                    handleFolder(probableFile);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Hiba a fájl dialogus során");
                }
            }

            private void handleFolder(File folder){
                try {
                    files.addAll(Arrays.asList(folder.listFiles()));
                }catch (Exception e){
                    showMessage("Hiba a fájlok megnyitásánál");
                }
            }

            private void handleSingleFile(File file){
                files.add(file);
            }

            private void diagramCreating(){
                for (File file: files) {
                    diagramFactory = new DiagramFactory(file.getAbsolutePath());
                    Optional<Diagram> diagram = diagramFactory.create();
                    if (diagram.isPresent()) {
                        diagrams.add(diagram.get());
                    }
                }
            }

            private void diagramParsing(){
                for (Diagram diagram: diagrams) {
                    diagram.parse();
                    if(diagram.checkStructureIsPresent() == true){
                        parseMessage += diagram.getStructureName() + " : " + diagram.getDisplayedName() + "\n";
                    } else {
                        parseMessage += diagram.getStructureName() + " : " + diagram.getDisplayedName() + "\n";
                        diagrams.remove(diagram);
                    }
                }
            }

            private void handleUserMessageAfterParse(){
                if(diagrams.isEmpty()){
                    showMessage("Nem sikerült egy diagramot sem beolvasni!");
                } else if(diagrams.isEmpty() == false){
                    showMessage("Beolvasott diagramok: "+ diagrams.size() + "\n" + parseMessage);
                }
            }

            private void setEnableGUIAfterParsing(){
                if(diagrams.size() > 0){
                    analyseGUIComponentEnableSetting(true);
                } else if (diagrams.isEmpty()){
                    analyseGUIComponentEnableSetting(false);
                }
            }

            private void analyseGUIComponentEnableSetting(boolean isEnabled){
                analyseBtn.setEnabled(isEnabled);
                ALLCheckEvent.setVisible(isEnabled);
                analyseConventionsPanel.setVisible(isEnabled);
            }

        });

        analyseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(conventions.isEmpty()){
                    showMessage("Egy konvenció sincs kiválasztva\n Legalább egy konvenció kiválasztása szükséges az analizáláshoz");
                } else {
                    AnalysersFactory analysersFactory;
                    for (Diagram diagram: diagrams) {
                        analysersFactory = new ClassDiagramAnalysersFactory(conventions);
                        diagram.analyse(analysersFactory.create());
                    }
                    showResult();
                }
            }

            private void showResult(){
                JFrame frame = new JFrame();
                frame.setTitle("Eredmények");
                frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                frame.setExtendedState(JFrame.MAXIMIZED_HORIZ);

                DefaultTableModel dtm = new DefaultTableModel();
                dtm.addColumn(new Object());
                dtm.addColumn(new Object());
                dtm.addRow(new Object[] { "Konvenció típus", "Üzenet"});

                for (Diagram diagram: diagrams) {
                    if(diagram.isReportEmpty() == false){
                        List<Reporter.Report> reports = diagram.getReports();
                        for (Reporter.Report report: reports) {
                            dtm.addRow(new Object[] { report.getConventionType(), report.getDescription()});
                        }
                    }
                }
                if(dtm.getRowCount() > 1) {

                    JTable table = new JTable();
                    table.setModel(dtm);
                    table.getColumnModel().getColumn(1).setMinWidth(1000);
                    table.add(new JScrollPane());

                    frame.add(table);
                    frame.setSize(new Dimension(1280, table.getRowCount() * 20));
                    frame.setMinimumSize(new Dimension(1280, table.getRowCount() * 20));
                    frame.setVisible(true);
                } else {
                    showMessage("Minden kiválasztott konvenciónak megfelelnek a diagramok");
                }
            }
        });

        ALLCheckEvent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(ALLCheckEvent.getText().equals("Összes kijelölése")){
                    setAllConvenctionCheckbox(true);
                    setAllConvenctionCheckBoxEnabled(false);
                    addAllConvention();
                    ALLCheckEvent.setText("Összes kijelölés törlése");

                } else {
                    setAllConvenctionCheckbox(false);
                    setAllConvenctionCheckBoxEnabled(true);
                    conventions = new ArrayList<>();
                    ALLCheckEvent.setText("Összes kijelölése");
                }

            }
            private void setAllConvenctionCheckbox(boolean flag){
                upperCaseNamingCb.setSelected(flag);
                atLeastOneAttributeOrBehaviore.setSelected(flag);
                interfaceOrAbstractClassHasAtLeastOneDerived.setSelected(flag);
                InterfaceOnlyPublic.setSelected(flag);
                InterfaceContainsAttribute.setSelected(flag);
                InterfaceContainsOnlyStaticAttributes.setSelected(flag);
                InterfaceHasPublicScope.setSelected(flag);
            }
            private void setAllConvenctionCheckBoxEnabled(boolean flag){
                upperCaseNamingCb.setEnabled(flag);
                atLeastOneAttributeOrBehaviore.setEnabled(flag);
                interfaceOrAbstractClassHasAtLeastOneDerived.setEnabled(flag);
                InterfaceOnlyPublic.setEnabled(flag);
                InterfaceContainsAttribute.setEnabled(flag);
                InterfaceContainsOnlyStaticAttributes.setEnabled(flag);
                InterfaceHasPublicScope.setEnabled(flag);
            }

            private void addAllConvention(){
                handleConventionUponEvent("firstUpperNameC",upperCaseNamingCb);
                handleConventionUponEvent("atLeastOneAttributeOrOperation",atLeastOneAttributeOrBehaviore);
                handleConventionUponEvent("interfaceOrAbstractClassHasAtLeastOneDerived",interfaceOrAbstractClassHasAtLeastOneDerived);
                handleConventionUponEvent("interfaceOnlyPublicFieldsAndOperations",InterfaceOnlyPublic);
                handleConventionUponEvent("interfaceContainsFields",InterfaceContainsAttribute);
                handleConventionUponEvent("interfaceOnlyStaticFields",InterfaceContainsOnlyStaticAttributes);
                handleConventionUponEvent("interfaceHasPublicScope", InterfaceHasPublicScope);
            }
        });

        upperCaseNamingCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleConventionUponEvent("firstUpperNameC",upperCaseNamingCb);
            }
        });

        atLeastOneAttributeOrBehaviore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleConventionUponEvent("atLeastOneAttributeOrOperation",atLeastOneAttributeOrBehaviore);
            }

        });
        interfaceOrAbstractClassHasAtLeastOneDerived.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleConventionUponEvent("interfaceOrAbstractClassHasAtLeastOneDerived",interfaceOrAbstractClassHasAtLeastOneDerived);
            }
        });
        InterfaceOnlyPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleConventionUponEvent("interfaceOnlyPublicFieldsAndOperations",InterfaceOnlyPublic);
            }
        });
        InterfaceContainsAttribute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleConventionUponEvent("interfaceContainsFields",InterfaceContainsAttribute);
            }
        });
        InterfaceContainsOnlyStaticAttributes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleConventionUponEvent("interfaceOnlyStaticFields",InterfaceContainsOnlyStaticAttributes);
            }
        });
        InterfaceHasPublicScope.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                handleConventionUponEvent("interfaceHasPublicScope", InterfaceHasPublicScope);
            }
        });

    }
    private void handleConventionUponEvent(String convention, JCheckBox checkBox){
        if(checkBox.isSelected()) {
            conventions.add(convention);
        } else {
            conventions.remove(convention);
        }
    }


    private void showMessage(String message){
        JOptionPane.showMessageDialog(mainPanel, message);
    }











    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setUndecorated(true);
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
