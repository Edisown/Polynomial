/**
 * Name: Edison M. Malasan
 * Date: 12/05/2024
 */
package prog2.samcis;

import java.util.*;

public class Term implements Comparable<Term>{
    private int exponent;
    private int numericalCoefficient;
    private char literalCoefficient;


    public Term(int numericalCoefficient, char literalCoefficient, int exponent) {
        this.exponent = exponent;
        this.numericalCoefficient = numericalCoefficient;
        this.literalCoefficient = literalCoefficient;
    }

    public int getNumericalCoefficient() {
        return numericalCoefficient;
    }
    public char getLiteralCoefficient() {
        return literalCoefficient;
    }

    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }


    public void setNumericalCoefficient(int numericalCoefficient) {
        this.numericalCoefficient = numericalCoefficient;
    }


    public void setLiteralCoefficient(char literalCoefficient) {
        this.literalCoefficient = literalCoefficient;
    }

    public int compareTo(Term other) {
        return Integer.compare(this.exponent, other.exponent);
    }

    public String toString() {
        if (exponent == 0) {
            return String.valueOf(numericalCoefficient);
        } else if (exponent == 1) {
            return  numericalCoefficient + String.valueOf(literalCoefficient);
        } else {
            return numericalCoefficient + String.valueOf(literalCoefficient) + "^" + exponent;
        }
    }

}
