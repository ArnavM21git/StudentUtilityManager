package studenttools.Utilities;

import javax.swing.*;
import java.awt.*;

public class UnitConverterFrame extends JFrame { 
    public UnitConverterFrame() { 
        setTitle("Engineering Unit Converter"); 
        setSize(350, 250); 
        setLayout(new GridLayout(5, 2, 5, 5)); 
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);
        
        JTextField input = new JTextField();
        input.setBackground(Color.WHITE);
        
        
        String[] conversions = {
            "°C to °F", "°F to °C", 
            "m to ft", "ft to m",
            "km to miles", "miles to km",
            "kg to lb", "lb to kg",
            "N to lbf", "lbf to N",
            "Pa to psi", "psi to Pa",
            "J to cal", "cal to J",
            "W to hp", "hp to W",
            "rad to deg", "deg to rad"
        };
        
        JComboBox<String> unitType = new JComboBox<>(conversions);
        unitType.setBackground(Color.WHITE);
        
        JButton convert = new JButton("Convert");
        convert.setBackground(new Color(255, 215, 0)); 
        JLabel result = new JLabel("Result: ", JLabel.CENTER);
        result.setFont(new Font("Arial", Font.BOLD, 14));

        convert.addActionListener(e -> {
            try {
                double val = Double.parseDouble(input.getText());
                String type = (String) unitType.getSelectedItem();
                double res = 0;
                
                switch (type) {
                    // Temperature
                    case "°C to °F": res = val * 9/5 + 32; break;
                    case "°F to °C": res = (val - 32) * 5/9; break;
                    
                    // Length
                    case "m to ft": res = val * 3.28084; break;
                    case "ft to m": res = val / 3.28084; break;
                    case "km to miles": res = val * 0.621371; break;
                    case "miles to km": res = val / 0.621371; break;
                    
                    // Mass
                    case "kg to lb": res = val * 2.20462; break;
                    case "lb to kg": res = val / 2.20462; break;
                    
                    // Force
                    case "N to lbf": res = val * 0.224809; break;
                    case "lbf to N": res = val / 0.224809; break;
                    
                    // Pressure
                    case "Pa to psi": res = val * 0.000145038; break;
                    case "psi to Pa": res = val / 0.000145038; break;
                    
                    // Energy
                    case "J to cal": res = val * 0.239006; break;
                    case "cal to J": res = val / 0.239006; break;
                    
                    // Power
                    case "W to hp": res = val * 0.00134102; break;
                    case "hp to W": res = val / 0.00134102; break;
                    
                    // Angle
                    case "rad to deg": res = val * 180/Math.PI; break;
                    case "deg to rad": res = val * Math.PI/180; break;
                }
                
                result.setText("Result: " + res);
            } catch (Exception ex) {
                result.setText("Invalid input - enter a number");
            }
        });

        add(new JLabel("Enter Value:", JLabel.RIGHT));
        add(input);
        add(new JLabel("Conversion Type:", JLabel.RIGHT));
        add(unitType);
        add(convert);
        add(result);

        // Add some empty space at the bottom
        add(new JLabel(""));
        add(new JLabel(""));

        setVisible(true);
    }
}