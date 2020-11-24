package View.GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Control.*;

public class CalendarWin extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private CalendarManager manager = null;
	private JTextField textFieldYear;
	private JTextField textFieldMonth;
	private JTextField textFieldDate;
	private JButton btnSave;
	private JButton btnRetrieve;
	private JTextArea textFieldContent;
	
	private JLabel labelYear = new JLabel("YYYY", JLabel.CENTER) ;
	private JLabel labelMonth = new JLabel("MM", JLabel.CENTER) ;
	private JLabel labelDate = new JLabel("DD", JLabel.CENTER) ;
	
	public CalendarWin(String title) {
        super(title);
    	
        JFrame.setDefaultLookAndFeelDecorated(true);
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        manager = new CalendarManager();
        
        createGUIControls();
	}
	
	private void createGUIControls() {
        JPanel panel = new JPanel();    
        panel.setLayout(null);
        add(panel);

        textFieldYear = new JTextField(8);
		textFieldYear.setFont(new Font(null, Font.PLAIN, 14));
		textFieldYear.setBounds(500, 10, 80, 20);
		textFieldYear.setText("2020");
		panel.add(textFieldYear);

		labelYear.setBounds(430, 10, 80, 20);
		panel.add(labelYear);
		labelMonth.setBounds(30, 10, 80, 20);
		panel.add(labelMonth);
		labelDate.setBounds(230, 10, 80, 20);
		panel.add(labelDate);
	
		textFieldMonth = new JTextField(8);
		textFieldMonth.setFont(new Font(null, Font.PLAIN, 14));
		textFieldMonth.setBounds(100, 10, 80, 20);
		textFieldMonth.setText("8");
		panel.add(textFieldMonth);
		
		textFieldDate = new JTextField(8);
		textFieldDate.setFont(new Font(null, Font.PLAIN, 14));
		textFieldDate.setBounds(300, 10, 80, 20);
		textFieldDate.setText("7");
		panel.add(textFieldDate);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(130, 50, 100, 30);
		btnSave.addActionListener(this);
		panel.add(btnSave);
		
		btnRetrieve = new JButton("Retrieve");
		btnRetrieve.setBounds(250, 50, 100, 30);
		btnRetrieve.addActionListener(this);
		panel.add(btnRetrieve);
		
		textFieldContent = new JTextArea("", 70, 8);
		textFieldContent.setFont(new Font(null, Font.PLAIN, 14));
		textFieldContent.setBounds(10, 100, 860, 430);
		textFieldContent.setText("");
		panel.add(textFieldContent);
	}
	
    public void actionPerformed(ActionEvent e) {
        JButton btn = (JButton)e.getSource();
        
        if (btn.getText() == "Save") {
            SaveContent();     	
        } else {
            LoadContent();
        }
    }
    
    public void SaveContent() {
    	int year, month, date;
    	String strContent = textFieldContent.getText();
    	year = Integer.parseInt(textFieldYear.getText());
    	month = Integer.parseInt(textFieldMonth.getText());
    	date = Integer.parseInt(textFieldDate.getText());
    	manager.save(strContent, year, month, date);
    }
    
    public void LoadContent() {
    	int year, month, date;
    	year = Integer.parseInt(textFieldYear.getText());
    	month = Integer.parseInt(textFieldMonth.getText());
    	date = Integer.parseInt(textFieldDate.getText());
    	String strContent = manager.load(year, month, date);
    	textFieldContent.setText(strContent);
    }
}
