/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package minor2;

/**
 *
 * @author reham
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{

    //declaring all necessary variables,buttons arrays,buttons,font,opearator
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton,subButton,mulButton,divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	
        //creating myfont for using in all frame
	Font myFont = new Font("Ink Free",Font.BOLD,30);
	
	double num1=0,num2=0,result=0;
	char operator;
	
        //constructor definition
	Calculator(){
		//defining the jframe
		frame = new JFrame("Calculator");
                frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 550);
		frame.setLayout(null);
		
                //tectfield definition
		textfield = new JTextField();
		textfield.setBounds(50, 25, 300, 50);
		textfield.setFont(myFont);
                //we can only enter values into textfield through buttons not directly...
		textfield.setEditable(false);
                frame.add(textfield);
		
                //all 9 functions buttons initialized and are given text to show on them on frame
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Del");
		clrButton = new JButton("Clr");
		negButton = new JButton("(-)");
		
                //all function buttons are stored in function buttons array
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
                //adding actionlistener function to all function buttons
		for(int i =0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
		}
		 //adding actionlistener function to all number buttons
		for(int i =0;i<10;i++) {
                     //all 10 (0 to 9)number buttons initialized and are given text to show on them on frame
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		}
                
                //middle panel creation to hold numbers and function buttons
                panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
                
		//negative,delete,clear buttons are provided at bottom of frame by setting their bounds
		negButton.setBounds(50,430,90,50);
		delButton.setBounds(155,430,90,50);
		clrButton.setBounds(260,430,90,50);
		
		
               //adding all buttons to panel
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
                
		//adding panel to frame
		frame.add(panel);
                
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
                
		
                
                //setting the frame to be visible
		frame.setVisible(true);
	}
	
        //main method only calls the constructor,where we created Ui for calculator
	public static void main(String[] args) {
		
		Calculator calc = new Calculator();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//this function runs from starting of the project
                //it needs any key to be pressed to calculate or enter values into textfield
                
                //for numberbutton press
		for(int i=0;i<10;i++) {
                    //e.getSource() is used to read values entered from UI created
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
                
                //action performed on pressing add button 
                if(e.getSource()==addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='+';
			textfield.setText("");
		}
                
                  //action performed on pressing sub button 
		if(e.getSource()==subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='-';
			textfield.setText("");
		}
                
		
                //action performed on pressing multiplication button 
		if(e.getSource()==mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='*';
			textfield.setText("");
		}
                
                //action performed on pressing  division  button 
		if(e.getSource()==divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator ='/';
			textfield.setText("");
		}
                
                //action performed on pressing  decimal/dot button 
                if(e.getSource()==decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
                
                //action performed on pressing  equal button 
		if(e.getSource()==equButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operator) {
			case'+':
				result=num1+num2;
				break;
			case'-':
				result=num1-num2;
				break;
			case'*':
				result=num1*num2;
				break;
			case'/':
				result=num1/num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
               
                //action performed on pressing neagation button
                if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
                
                //action performed on pressing delete previously entered value button
                if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText(string.substring(0,string.length()-1));
		}
                
                //action performed on pressing clear button
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		
		
	}
}