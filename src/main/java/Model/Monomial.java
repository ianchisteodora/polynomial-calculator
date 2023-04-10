package Model;

public class Monomial {
     int coeff;
     int degree;

    public Monomial() {
        this.coeff = 0;
        this.degree = 0;
    }

    ;

    //constructor
    public Monomial(int coeff, int degree) {
        this.coeff = coeff;
        this.degree = degree;
    }

    //getters & setters

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getDegree() {
        return degree;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }

    public int getCoeff() {
        return coeff;
    }


    @Override
    public String toString() {
        return coeff + "x" + "^" + degree;

    }

    public void addMonom(Monomial m) {
        this.coeff += m.getCoeff();
    }

    public void subMonom(Monomial m){
        this.coeff -= m.getCoeff();
    }

    public Monomial multiplyMonom(Monomial m) {
        return new Monomial(coeff * m.coeff, degree + m.degree);

    }
}

