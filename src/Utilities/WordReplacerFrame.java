package studenttools.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WordReplacerFrame extends JFrame {
    File currentFile;
    public WordReplacerFrame() {
        setTitle("Word Replacer");
        setSize(500, 400);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.GRAY); 
        
        // Create main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // Text area for input
        JTextArea textArea = new JTextArea();
        textArea.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(textArea);
        
        JMenuBar mb=new JMenuBar();
        setJMenuBar(mb);
        JMenu menu=new JMenu("File");
        mb.add(menu);
        JMenuItem mi=new JMenuItem("Open");
        menu.add(mi);
        
        mi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newText;
                try {
                    JFileChooser ff=new JFileChooser();
                    int i=ff.showOpenDialog(WordReplacerFrame.this);
                    if(i==JFileChooser.APPROVE_OPTION) {
                        currentFile=ff.getSelectedFile();
                        String pa=currentFile.getPath();
                        String str1="",str2="";
                        try (BufferedReader br = new BufferedReader(new FileReader(pa))) {
                            while((str2=br.readLine())!=null) {
                                str1=str1+str2+"\n";
                            }
                            textArea.setText(str1);
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }
                        
                        newText=textArea.getText();
                        
                        JFileChooser ff1 = new JFileChooser();//new created as it was immediately reading so printing same
                        File fff1 = ff1.getSelectedFile();
                        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fff1))) {
                            bw.write(newText);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    }
                } catch(Exception k) {}
            }
        });
        
        // Panel for controls
        JPanel controlPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        
        // Fields for find and replace
        JTextField findField = new JTextField();
        JTextField replaceField = new JTextField();
        
        // Buttons
        JButton replaceBtn = new JButton("Replace All");
        replaceBtn.setBackground(new Color(150, 255, 150)); 
        JButton clearBtn = new JButton("Clear All");
        clearBtn.setBackground(new Color(255, 150, 150)); 
        
        // Result label
        JLabel resultLabel = new JLabel("Ready", JLabel.CENTER);
        resultLabel.setBorder(BorderFactory.createEtchedBorder());
        
        // Add components to control panel
        controlPanel.add(new JLabel("Find Word:"));
        controlPanel.add(findField);
        controlPanel.add(new JLabel("Replace With:"));
        controlPanel.add(replaceField);
        controlPanel.add(replaceBtn);
        controlPanel.add(clearBtn);
        
        // Set up button actions
        replaceBtn.addActionListener(e -> {
            String text = textArea.getText();
            String find = findField.getText();
            String replace = replaceField.getText();
            
            if (text.isEmpty() || find.isEmpty()) {
                resultLabel.setText("Nothing to replace");
                return;
            }
            
            int count = 0;
            if (text.contains(find)) 
            {
                String newText1 = text.replace(find, replace);
                textArea.setText(newText1);
                
               
                
                resultLabel.setText("Replaced Sucessfully...");
                
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(currentFile))) {
                    bw.write(textArea.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Error saving file: " + ex.getMessage());
                }
            } 
            else 
            {
                resultLabel.setText("Word not found");
            }
        });
        
        clearBtn.addActionListener(e -> {
            textArea.setText("");
            findField.setText("");
            replaceField.setText("");
            resultLabel.setText("Cleared");
        });
        
        // Add components to main panel
        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(controlPanel, BorderLayout.NORTH);
        mainPanel.add(resultLabel, BorderLayout.SOUTH);
        
        add(mainPanel);
        setVisible(true);
    }
}