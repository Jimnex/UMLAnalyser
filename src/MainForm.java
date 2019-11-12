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
    private JCheckBox UpperStartNamingAnalyserCB;
    private JCheckBox checkBox2;
    private JCheckBox checkBox3;
    private JCheckBox checkBox4;
    private JCheckBox checkBox5;
    private JCheckBox checkBox6;
    private JCheckBox checkBox7;
    private JCheckBox checkBox8;
    private JCheckBox checkBox9;
    private JCheckBox checkBox10;
    private JLabel UpperStartNamingAnalyserLabel;
    private JPanel analyseConventionsPanel;
    List<File> files = new ArrayList<>();
    DiagramFactory diagramFactory;
    List<Diagram> diagrams = new ArrayList<>();


    public MainForm() {
        analyseConventionsPanel.setVisible(false);


        parseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //region File handling
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                fileChooser.showOpenDialog(buttonsPanel);
                File probableFile = fileChooser.getSelectedFile();
                if(probableFile.isFile()) {
                   handleSingleFile(probableFile);
                } else if(probableFile.isDirectory()) {
                    handleFolder(probableFile);
                } else {
                    JOptionPane.showMessageDialog(mainPanel, "Nem támogatott megnyitási lehetőség");
                }
                //endregion
                //region Diagram parsing
                for (File file: files) {
                    diagramFactory = new DiagramFactory(probableFile.getAbsolutePath());
                    Optional<Diagram> diagram = diagramFactory.create();
                    if (diagram.isPresent()) {
                        diagrams.add(diagram.get());
                    }
                }
                for (Diagram diagram: diagrams) {
                    diagram.parse();
                }

                analyseConventionsPanel.setVisible(false);
                //endregion
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
            JOptionPane.showMessageDialog(mainPanel, "Hiba a fájlok megnyitásánál");
        }
    }

    private void handleSingleFile(File file){
        files.add(file);
    }



    public static void main(String[] args) {
        JFrame frame = new JFrame("MainForm");
        frame.setContentPane(new MainForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);
        frame.setVisible(true);
    }
}
