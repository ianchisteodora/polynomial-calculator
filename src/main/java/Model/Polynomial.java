package Model;

import java.util.List;
import java.util.TreeMap;

public class Polynomial {
    TreeMap<Integer, Integer> monomials;

    public Polynomial() {
        this.monomials = new TreeMap<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int degree : monomials.descendingKeySet()) {
            int coefficient = monomials.get(degree);
            if (coefficient != 0) {
                sb.append(coefficient);
                if (degree > 0) {
                    sb.append("x");
                    if (degree > 1) {
                        sb.append("^").append(degree);
                    }
                }
                sb.append(" + ");
            }
        }
        if (sb.length() == 0) {
            sb.append("0");
        } else {
            sb.setLength(sb.length() - 3);
        }
        return sb.toString();
    }

    public static Polynomial parser(String input) {
        Polynomial result = new Polynomial();
        input = input.replaceAll("\\s+", "");
        String[] monomialStrings = input.split("(?=[-+])");
        for (String monomialString : monomialStrings) {
            int coefficient = 1;
            int degree = 0;
            if (monomialString.charAt(0) == '-') {
                coefficient = -1;
                monomialString = monomialString.substring(1);
            } else if (monomialString.charAt(0) == '+') {
                monomialString = monomialString.substring(1);
            }
            int xIndex = monomialString.indexOf("x");
            if (xIndex >= 0) {
                degree = 1;
                if (xIndex > 0) {
                    coefficient = Integer.parseInt(monomialString.substring(0, xIndex));
                }
                int caretIndex = monomialString.indexOf("^");
                if (caretIndex > xIndex) {
                    degree = Integer.parseInt(monomialString.substring(caretIndex + 1));
                }
            } else {
                coefficient = Integer.parseInt(monomialString);
            }
            coefficient += result.monomials.getOrDefault(degree, 0);
            if (coefficient != 0) {
                result.monomials.put(degree, coefficient);
            } else {
                result.monomials.remove(degree);
            }
        }
        return result;
    }
}
