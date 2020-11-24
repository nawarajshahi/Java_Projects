import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.text.DecimalFormat;

public class MainFrame extends JFrame{
	
    JTextField inputBox;
    JTextField outputBox;
    
    JRadioButton fromCel;
    JRadioButton fromFah;
    JRadioButton fromKel;
    
    JRadioButton toCel;
    JRadioButton toFah;
    JRadioButton toKel;
    
    public MainFrame(String title) {
        super(title);
    	
        JFrame.setDefaultLookAndFeelDecorated(true);
        setSize(510, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	createAndShowGUI();
    }
   
	public void createAndShowGUI() {
        JPanel panel = new JPanel();    
        panel.setLayout(null);
        add(panel);
        
        JLabel inputLabel = new JLabel("Input");
        inputLabel.setBounds(180, 10, 30, 20);;
        panel.add(inputLabel);
                
        inputBox = new JTextField(8);
        inputBox.setFont(new Font(null, Font.PLAIN, 14));
        inputBox.setBounds(220, 10, 80, 20);
        inputBox.setText("-125");
        panel.add(inputBox);
        
        JLabel outputLabel = new JLabel("Output");
        outputLabel.setBounds(170, 230, 40, 20);
        panel.add(outputLabel);
        
        outputBox = new JTextField(8);
        outputBox.setFont(new Font(null, Font.PLAIN, 14));
        outputBox.setBounds(220, 230, 80, 20);
        outputBox.setText("-398.15" + (char)176 + "C");
        panel.add(outputBox);
        
        JPanel fromTemp = new JPanel();
        fromTemp.setBounds(10, 50, 150, 150);
        fromTemp.setBorder(BorderFactory.createTitledBorder("Input Scale"));
        fromTemp.setLayout(null);
        
        theHandler handleEvent = new theHandler();
        
        fromCel = new JRadioButton("Celsius");
        fromCel.setBounds(10, 30, 100, 20);
        fromCel.addItemListener(handleEvent);
        
        fromFah = new JRadioButton("Fahrenheit");
        fromFah.setBounds(10, 70, 100, 20);
        fromFah.addItemListener(handleEvent);
        
        fromKel = new JRadioButton("Kelvin", true);
        fromKel.setBounds(10, 110, 100, 20);
        fromKel.addItemListener(handleEvent);
        
        ButtonGroup fromGroup = new ButtonGroup();
        fromGroup.add(fromCel);
        fromGroup.add(fromFah);
        fromGroup.add(fromKel);
        
        fromTemp.add(fromCel);
        fromTemp.add(fromFah);
        fromTemp.add(fromKel);
        
        panel.add(fromTemp);
        
        JPanel toTemp = new JPanel();
        toTemp.setBounds(330, 50, 150, 150);
        toTemp.setBorder(BorderFactory.createTitledBorder("Output Scale"));
        toTemp.setLayout(null);
        
        toCel = new JRadioButton("Celsius", true);
        toCel.setBounds(10, 30, 100, 20);
        toCel.addItemListener(handleEvent);
        toFah = new JRadioButton("Fahrenheit");
        toFah.setBounds(10, 70, 100, 20);
        toFah.addItemListener(handleEvent);
        toKel = new JRadioButton("Kelvin");
        toKel.setBounds(10, 110, 100, 20);
        toKel.addItemListener(handleEvent);
        
        ButtonGroup toGroup = new ButtonGroup();
        toGroup.add(toCel);
        toGroup.add(toFah);
        toGroup.add(toKel);
        
        toTemp.add(toCel);
        toTemp.add(toFah);
        toTemp.add(toKel);

        panel.add(toTemp);
        setVisible(true);
    }
	
	private class theHandler implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			char charUnit[] = {'C', 'F', 'K'};
			int fromTempUnit = 0, toTempUnit = 0;
			if (fromCel.isSelected()) fromTempUnit = 0;
			if (fromFah.isSelected()) fromTempUnit = 1;
			if (fromKel.isSelected()) fromTempUnit = 2;
			
			if (toCel.isSelected()) toTempUnit = 0;
			if (toFah.isSelected()) toTempUnit = 1;
			if (toKel.isSelected()) toTempUnit = 2;
			
			String inputValue = inputBox.getText();
			if (inputValue.compareTo("") == 0) {
				outputBox.setText("No Input");			
			} else {
				double inputVal = Double.valueOf(inputValue);
				double outputVal = TempConv.ConvertTemperature(inputVal, fromTempUnit, toTempUnit);
				DecimalFormat df = new DecimalFormat("######0.00"); 
				outputBox.setText(df.format(outputVal) + (char)176 + charUnit[toTempUnit]);
								
			}
		}
	}

}
