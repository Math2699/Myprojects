/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualcalculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import calculadora.Calculadora;
import java.awt.event.ActionEvent;


class JKeyboard
{
    JPanel pnlmain;
    JPanel pnldigits;
    JPanel pnloperators;
    JButton[] jbtndigits;
    JButton jbtndel;
    JButton[] jbtnoperators;
    JButton jbtnequal;
    
    JKeyboard() {
        this.jbtndigits = new JButton[11];
        this.jbtnoperators = new JButton[5];
        this.pnlmain = new JPanel();
        this.pnldigits = new JPanel(new GridLayout(4, 4, 15, 12));
        this.pnloperators = new JPanel(new GridLayout(5, 1, 8, 3));
        final char[] digits = { '9', '8', '7', '6', '5', '4', '3', '2', '1', '0', '.' };
        final char[] operators = { '+', '-', 'x', '/' };
        for (int i = 0; i < digits.length; ++i) {
            (this.jbtndigits[i] = new JButton("" + digits[i])).setMargin(new Insets(1, 1, 1, 1));
            this.pnldigits.add(this.jbtndigits[i]);
        }
        this.pnldigits.add(this.jbtnequal = new JButton("="));
        for (int i = 0; i < operators.length; ++i) {
            (this.jbtnoperators[i] = new JButton("" + operators[i])).setMargin(new Insets(2, 2, 2, 2));
            this.pnloperators.add(this.jbtnoperators[i]);
        }
        this.pnloperators.add(this.jbtndel = new JButton("<="));
        this.pnlmain.add(this.pnldigits, "West");
        this.pnlmain.add(this.pnloperators, "East");
    }
    
    public void AddActionListeners(final ActionListener keyboardListener) {
        final char[] digits = { '9', '8', '7', '6', '5', '4', '3', '2', '1', '0', '.' };
        final char[] operators = { '+', '-', 'x', '/' };
        for (int i = 0; i < digits.length; ++i) {
            this.jbtndigits[i].addActionListener(keyboardListener);
        }
        for (int i = 0; i < operators.length; ++i) {
            this.jbtnoperators[i].addActionListener(keyboardListener);
        }
        this.jbtnequal.addActionListener(keyboardListener);
        this.jbtndel.addActionListener(keyboardListener);
    }
}

public class VirtualCalculator implements ActionListener
{
    Calculadora Cal;
    String a;
    String b;
    String op;
    double c;
    JLabel jscreen;
    JKeyboard jkeyboard;
    
    private VirtualCalculator() {
        this.Cal = new Calculadora();
        this.a = "";
        this.b = "";
        this.op = "";
        this.c = 0.0;
        final JFrame frCase = new JFrame("Virtual Calculator");
        (this.jscreen = new JLabel("", 4)).setText("Pulse los Botones");
        (this.jkeyboard = new JKeyboard()).AddActionListeners((ActionListener)this);
        frCase.add(this.jscreen, "North");
        frCase.add(this.jkeyboard.pnlmain, "South");
        frCase.setSize(250, 300);
        frCase.setLocation(300, 200);
        frCase.setVisible(true);
        frCase.setResizable(false);
        frCase.setDefaultCloseOperation(3);
    }
    
   @Override
    public void actionPerformed(final ActionEvent e) {
        final String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "<=": {
                if (this.b.length() != 0) {
                    this.b = this.b.substring(0, this.b.length() - 1);
                    break;
                }
                if (this.op.length() != 0) {
                    this.op = this.op.substring(0, this.op.length() - 1);
                    break;
                }
                if (this.a.length() != 0) {
                    this.a = this.a.substring(0, this.a.length() - 1);
                    break;
                }
                break;
            }
            case "+": {
                this.op = actionCommand;
                break;
            }
            case "-": {
                this.op = actionCommand;
                break;
            }
            case "x": {
                this.op = actionCommand;
                break;
            }
            case "/": {
                this.op = actionCommand;
                break;
            }
            case "=": {
                this.a = Float.toString((float)this.Cal.Calcular((double)Float.parseFloat(this.a), this.op, (double)Float.parseFloat(this.b)));
                this.b = "";
                this.op = "";
                break;
            }
            default: {
                if (this.op.isEmpty()) {
                    this.a += actionCommand;
                    break;
                }
                this.b += actionCommand;
                break;
            }
        }
        jscreen.setText(a+op+b);
    }
    
    public static void main(final String[] args) {
        if (args.length == 0) {
            SwingUtilities.invokeLater(VirtualCalculator::new);
        }
        else {
            final Calculadora Cal1 = new Calculadora();
            System.out.println("Hola Soy la Calculadora de Mateo");
            try {
                System.out.println("El resultado es: " + Cal1.Calcular((double)Float.parseFloat(args[0]), args[1], (double)Float.parseFloat(args[2])));
            }
            catch (NumberFormatException e) {
                System.out.println("Numero de Argumentos o valores Invalidos. Ej. 2 + 3 ");
            }
        }
    }
}