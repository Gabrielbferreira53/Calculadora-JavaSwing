package com.mycompany.swingcalculadora;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OperationsPanel extends JPanel implements ActionListener{
    
    private final JTextField txtText;
    
    private char op;
    private double value1;//para armazenar informações de digitação.
    private double value2;
    
    private  JButton btnAdd;
    private  JButton btnSub;
    private  JButton btnMult;
    private  JButton btnDiv;
    private JButton btnExp;
    private  JButton btnEq;
    private  JButton btnClear;
    private JButton btnEmpty3;
      
    
    public OperationsPanel(JTextField txtText){
        this.txtText = txtText;
        
        setLayout(new GridLayout(4,2));
        
        btnAdd = new JButton("+");
        btnAdd.addActionListener(this);
        add(btnAdd);
        
        btnSub = new JButton("-");
        btnSub.addActionListener(this);
        add(btnSub);
        
        btnMult = new JButton("*");
        btnMult.addActionListener(this);
        add(btnMult);
        
        btnDiv = new JButton("/");
        btnDiv.addActionListener(this);
        add(btnDiv);
        
        btnExp = new JButton("e");
        btnExp.addActionListener(this);
        add(btnExp);
        
        btnEq = new JButton("=");
        btnEq.addActionListener(this);
        add(btnEq);
        
        btnClear = new JButton("C");
        btnClear.addActionListener(this);
        add(btnClear);
        
        btnEmpty3 = new JButton(""); // Botão vazio
        add(btnEmpty3);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if (txtText.getText().isEmpty()){ //Pra quando não houver numeros digitados ainda.
            return;
        }
        
        
        JButton btn = (JButton) e.getSource();
        
        if (btn == btnClear){
            op = '\u0000';//definição de Null para char.
            txtText.setText("");
        } else if (btn == btnEq) {
            value2 = Double.parseDouble(txtText.getText());
            
            double result = 0.00;
            
            if (op == '+') {
                result = value1 + value2;
            } else if (op == '-') {
                result = value1 - value2;
            } else if (op =='*') {
                result = value1 * value2;
            } else if (op == '/') {
                result = value1 / value2;
            } else if (op == 'e') { 
                result = Math.pow(value1, value2);
            }
        
        txtText.setText(String.valueOf(result));//result primitivo para String com metodo estatico.
        op = '\u0000';
        value1 = result;
        value2 = 0;
        
        } else {
            op = btn.getText ().charAt(0);
            value1 = Double.parseDouble(txtText.getText());
            txtText.setText("");//Limpa opereção de caixa de texto.
    }
    }
    }
