package com.mycompany.swingcalculadora;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Calc extends JFrame {
    
    public Calc() throws Exception {
        super ("Calculadora");
    
       UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
       
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Ao clicar em fechar aplicação fecha a Calc.
       setSize(350,350);//tamanho da janela.
       setLocation(400,200); //localização na tela.
       
       setLayout(new BorderLayout());
       
        TextPanel textPanel = new TextPanel();
       add(BorderLayout.NORTH,textPanel);
       
      
       JPanel digitsPanel = new JPanel();
       digitsPanel.setLayout(new BorderLayout());
       digitsPanel.add(BorderLayout.CENTER, new NumbersPanel (textPanel.getTxtNumber()));
       digitsPanel.add(BorderLayout.EAST, new OperationsPanel(textPanel.getTxtNumber()));
       
      add(BorderLayout.CENTER, digitsPanel);
       
       setVisible(true); //metodo para iniciar janela.
    }
    
    public static void main (String[] args) throws Exception{
      new Calc();
    }
    }

