import analyser.Analyser;
import analyser.umlclass.FirstUpperCharNamingConvention;
import factory.AnalysersFactory;
import factory.ClassDiagramAnalysersFactory;
import factory.DiagramFactory;
import uml.diagrams.Diagram;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;


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
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JCheckBox checkBox11;
    private JPanel analyseConventionsPanel;
    List<File> files;
    DiagramFactory diagramFactory;
    List<Diagram> diagrams;
    List<String> conventions = new ArrayList<>();


    public MainForm() {
        analyseBtn.setEnabled(false);
        analyseConventionsPanel.setVisible(false);

        parseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                files = new ArrayList<>();
                diagrams = new ArrayList<>();
                fileHandling();
                diagramCreating();
                diagramParsing();
            }
        });
        analyseBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AnalysersFactory analysersFactory;
                for (Diagram diagram: diagrams) {
                    analysersFactory = new ClassDiagramAnalysersFactory(conventions);
                    diagram.analyse(analysersFactory.create());
                }
                showResult();
            }
        });
        upperCaseNamingCb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                conventions.add("firstUpperNameC");
            }
        });
        atLeastOneAttributeOrBehaviore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                conventions.add("atLeastOneAttributeOrOperation");
            }
        });
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

    private void showMessage(String errorMessage){
        JOptionPane.showMessageDialog(mainPanel, errorMessage);
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
        String parseMessage = "";
        for (Diagram diagram: diagrams) {
            diagram.parse();
            if(diagram.checkStructureIsPresent() == true){
                parseMessage += diagram.getStructure().getName() + " nevű " + diagram.getDisplayedName() + " sikeresen beolvasva\n";
            } else {
                parseMessage += diagram.getStructure().getName() + " nevű " + diagram.getDisplayedName() + " nem sikerült beolvasni\n";
                diagrams.remove(diagram);
            }
        }
        showMessage(parseMessage);
        if(diagrams.size() > 0){
            analyseBtn.setEnabled(true);
            analyseConventionsPanel.setVisible(true);
        }

    }

    private void showResult(){
        String reports = "";
        for (Diagram diagram: diagrams) {
            reports += diagram.getReport() + "\n";
        }
        showMessage(reports);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,600);
        frame.setVisible(true);
    }
}
