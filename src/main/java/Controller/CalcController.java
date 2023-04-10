package Controller;

import Model.Operations;
import Model.Polynomial;
import View.View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController implements ActionListener {
    public Operations op = new Operations();
    private View view;
    private Polynomial p1;
    private Polynomial p2;
    public CalcController(View view){
        this.view = view;
        this.p1 = new Polynomial();
        this.p2 = new Polynomial();
    }


    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        String polinom1 = view.getText1stpoly().getText();
        String polinom2 = view.getText2ndpoly().getText();

        p1 = p1.parser(polinom1);
        p2 = p2.parser(polinom2);

        if(source == this.view.getAddBTN()){
            Polynomial result = op.add(p1, p2);
            view.getResultTXT().setText(result.toString());
        }
        if(source == this.view.getSubBTN()){
            Polynomial result = op.subtract(p1, p2);
            view.getResultTXT().setText(result.toString());
        }
        if(source == this.view.getDerivateBTN()){
            Polynomial result = op.deriv(p1);
            view.getResultTXT().setText(result.toString());
        }
        if(source == this.view.getMulBTN()){
            Polynomial result = op.multiply(p1, p2);
            view.getResultTXT().setText(result.toString());
        }

        if(source == this.view.getIntegrateBTN()){
            Polynomial result = op.integrate(p1);
            view.getResultTXT().setText(result.toString());
        }

        if(source == this.view.getClearBTN()) {
            view.getResultTXT().setText("");
            view.getText1stpoly().setText("");
            view.getText2ndpoly().setText("");
        }

    }
}
