package View;

import javax.swing.*;
import Controller.CalcController;

public class View extends JFrame {
    public JPanel panel1;
    private JPanel panel2;
    private JTextField text1stpoly;
    private JTextField text2ndpoly;
    private JButton clearBTN;
    private JButton addBTN;
    private JButton subBTN;
    private JButton mulBTN;
    private JButton integrateBTN;
    private JButton derivateBTN;
    private JTextField resultTXT;
    private JFrame viewFrame;

    CalcController calcController = new CalcController(this);
    public  View() {
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(panel1);
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        this.clearBTN.addActionListener(this.calcController);
        this.addBTN.addActionListener(this.calcController);
        this.subBTN.addActionListener(this.calcController);
        this.mulBTN.addActionListener(this.calcController);
        this.integrateBTN.addActionListener(this.calcController);
        this.derivateBTN.addActionListener(this.calcController);
    }


        public JTextField getText1stpoly(){
        return this.text1stpoly;
        }
        public JTextField getText2ndpoly(){
        return this.text2ndpoly;
        }

    public void setText1stpoly(JTextField text1stpoly) {
        this.text1stpoly = text1stpoly;
    }

    public void setText2ndpoly(JTextField text2ndpoly) {
        this.text2ndpoly = text2ndpoly;
    }

    public void setResultTXT(JTextField resultTXT) {
        this.resultTXT = resultTXT;
    }

    public JButton getClearBTN(){
        return this.clearBTN;
        }
        public JButton getAddBTN(){
        return this.addBTN;
        }
        public JButton getSubBTN(){
        return this.subBTN;
        }
        public JButton getMulBTN(){
        return this.mulBTN;
        }
        public JButton getIntegrateBTN(){
        return this.integrateBTN;
        }
        public JButton getDerivateBTN(){
        return this.derivateBTN;
        }

        public JTextField getResultTXT(){
        return this.resultTXT;
        }




    }

