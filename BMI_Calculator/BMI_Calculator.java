
/**
 * Write a description of class BMI_Calculator here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class BMI_Calculator
{
    //Declarations
    JFrame frame = new JFrame();
    
    JButton compute = new JButton();
    JButton clear = new JButton();
    JButton exit = new JButton();
    
    JLabel height = new JLabel();
    JLabel weight = new JLabel();
    JLabel bmi = new JLabel();
    JLabel feet = new JLabel();
    JLabel inches = new JLabel();
    JLabel pounds = new JLabel();
    
    JTextArea fText = new JTextArea();
    JTextArea pText = new JTextArea();
    JTextArea iText = new JTextArea();
    JTextArea bmiText = new JTextArea();
    
    GridBagConstraints gridCons = new GridBagConstraints();
    
    public BMI_Calculator(){
        frame.setTitle("BMI Calculator");
        frame.setVisible(true);
        frame.getContentPane().setLayout(new GridBagLayout());
        
        //ADDING Labels
        addALabel(height,"Height: ", 0, 0);
        addALabel(weight, "Weight: ", 0, 1);
        addALabel(bmi, "BMI: ", 0, 2);
        
        addALabel(feet, "feet", 2, 0);
        addALabel(inches, "inches", 4, 0);
        addALabel(pounds, "pounds", 2, 1);
        
        //ADDING text areas
        addATextArea(fText, 1, 0, 8);
        addATextArea(pText, 1, 1, 8);
        addATextArea(bmiText, 1, 2, 15);
        addATextArea(iText, 3, 0, 8);
        
        //ADDING buttons
        addAButton(compute, "Compute BMI", 1, 4);
        compute.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        bmiGet();}});
        
        addAButton(clear, "Clear", 2, 4);
        clear.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        clear();}});
        
        addAButton(exit, "Exit", 4, 4);
        exit.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e){
        System.exit(0);}});
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
    }
    
    //------------------------------ADDING_ELEMENTS----------------------------------------------------
    private void addALabel(JLabel _label, String text, int x, int y){
        _label.setText(text);
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.add(_label, gridCons);
    }
    
    private void addATextArea(JTextArea _textArea, int x, int y, int _columns){
        _textArea.setColumns(_columns);
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.add(_textArea, gridCons);
    }
    
    private void addAButton(JButton _button, String text, int x, int y){
        _button.setText(text);
        gridCons.gridx = x;
        gridCons.gridy = y;
        frame.add(_button, gridCons);
    }
    
    //------------------------------ACTION_PERFORMED----------------------------------------------------
    private void bmiGet(){
        String feetInput = fText.getText();
        String inchesInput = iText.getText();
        String poundsInput = pText.getText();
        
        double feetNum = Double.parseDouble(feetInput);
        double inchesNum = Double.parseDouble(inchesInput);
        double poundsNum = Double.parseDouble(poundsInput);
        
        double total_inches = (feetNum*12) + inchesNum;
        double bmi_result = (poundsNum / (total_inches * total_inches)) * 703;
        
        bmiText.setText(""+bmi_result);
    }
    
    private void clear(){
        bmiText.setText("");
        fText.setText("");
        iText.setText("");
        pText.setText("");
    }
    
    //-------------------------------MAIN---------------------------------------------------------------
    public static void main(String[] args){
        BMI_Calculator bmi = new BMI_Calculator();
        
    }
}
