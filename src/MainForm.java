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
    List<File> files = new ArrayList<>();
    DiagramFactory diagramFactory;
    List<Diagram> diagrams = new ArrayList<>();


    public MainForm() {

        parseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileHandling();
                diagramCreating();
                diagramParsing();
            }
        });
        analyseBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                for (Diagram diagram: diagrams) {
                }
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
        String successFullMessage = "";
        for (Diagram diagram: diagrams) {
            diagram.parse();
            if(diagram.checkStructureIsPresent() == true){
                successFullMessage += diagram.getStructure().getName() + " nevű " + diagram.getDisplayedName() + " sikeresen beolvasva\n";
            }
        }
        showMessage(successFullMessage);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
