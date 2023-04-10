package Model;

public class Operations {

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (int degree : p1.monomials.keySet()) {
            int coefficient = p1.monomials.get(degree);
            result.monomials.put(degree, coefficient);
        }
        for (int degree : p2.monomials.keySet()) {
            int coefficient = p2.monomials.get(degree);
            int currentCoefficient = result.monomials.getOrDefault(degree, 0);
            result.monomials.put(degree, coefficient + currentCoefficient);
        }
        return result;
    }
    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (int degree : p1.monomials.keySet()) {
            int coefficient = p1.monomials.get(degree);
            result.monomials.put(degree, coefficient);
        }
        for (int degree : p2.monomials.keySet()) {
            int coefficient = p2.monomials.get(degree);
            int currentCoefficient = result.monomials.getOrDefault(degree, 0);
            result.monomials.put(degree, currentCoefficient - coefficient);
        }
        return result;
    }


    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (int degree1 : p1.monomials.keySet()) {
            for (int degree2 : p2.monomials.keySet()) {
                int coefficient1 = p1.monomials.get(degree1);
                int coefficient2 = p2.monomials.get(degree2);
                int newDegree = degree1 + degree2;
                int newCoefficient = coefficient1 * coefficient2;
                int currentCoefficient = result.monomials.getOrDefault(newDegree, 0);
                result.monomials.put(newDegree, currentCoefficient + newCoefficient);
            }
        }
        return result;
    }

    public static Polynomial integrate(Polynomial p) {
        Polynomial result = new Polynomial();
        for (int degree : p.monomials.keySet()) {
            int coefficient = p.monomials.get(degree);
            int newCoefficient = coefficient / (degree + 1);
            if (result.monomials.containsKey(degree)) {
                result.monomials.put(degree, result.monomials.get(degree + 1) + newCoefficient);
            } else {
                result.monomials.put(degree + 1, newCoefficient);
            }
        }
        return result;
    }




    public static Polynomial deriv(Polynomial p) {
        Polynomial result = new Polynomial();
        for (int degree : p.monomials.keySet()) {
            int coefficient = p.monomials.get(degree);
            if (degree > 0) {
                int newDegree = degree - 1;
                int newCoefficient = coefficient * degree;
                result.monomials.put(newDegree, newCoefficient);
            }
        }
        return result;
    }

}



