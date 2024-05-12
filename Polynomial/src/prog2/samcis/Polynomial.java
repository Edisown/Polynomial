/**
 * Name: Edison M. Malasan
 * Date: 12/05/2024
 */
package prog2.samcis;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Polynomial implements PolynomialMethods{
    private List<Term> listTerms;


    public Polynomial() {
        this.listTerms = new ArrayList<>();
    }

    public Polynomial(List<Term> listTerms) {
        this.listTerms = listTerms;
    }


    public void add(Term terms) {
        listTerms.add(terms);
        Collections.sort(listTerms);
    }

    public double evaluator() {
        double result = 0;

        for (Term terms : listTerms) {
            result = result + terms.getNumericalCoefficient() * Math.pow(2, terms.getExponent());
        }
        return result;
    }

    // Interface Methods

    public Polynomial add(Polynomial polynomial) {
        List<Term> resultTerms = new ArrayList<>(this.listTerms);
        resultTerms.addAll(polynomial.listTerms);
        return new Polynomial(resultTerms);
    }


    public Polynomial subtract(Polynomial polynomial) {
        List<Term> resultTerms = new ArrayList<>(this.listTerms);
        for (Term terms : polynomial.listTerms) {
            resultTerms.add(new Term(-terms.getNumericalCoefficient(), terms.getLiteralCoefficient(), terms.getExponent()));
        }
        return new Polynomial(resultTerms);
    }

    @Override
    public Polynomial multiply(Polynomial polynomial) {
        List<Term> resultTerms = new ArrayList<>();
        for (Term term1 : this.listTerms) {
            for (Term term2 : polynomial.listTerms) {
                resultTerms.add(new Term(term1.getNumericalCoefficient() * term2.getNumericalCoefficient(),
                        term1.getLiteralCoefficient(), term1.getExponent() + term2.getExponent()));
            }
        }
        return new Polynomial(resultTerms);
    }


    @Override
    public Polynomial divide(Polynomial polynomial) {
        //create an arraylist to store the quotient and remainder terms
        List<Term> quotientTerms = new ArrayList<>();
        List<Term> remainderTerms = new ArrayList<>(this.listTerms);

        while (!remainderTerms.isEmpty() && remainderTerms.get(0).getExponent() >= polynomial.getLeadingTerm().getExponent()) {
            Term leadingTermDividend = remainderTerms.get(0);
            Term leadingTermDivisor = polynomial.getLeadingTerm();

            int newCoefficient = leadingTermDividend.getNumericalCoefficient() / leadingTermDivisor.getNumericalCoefficient();
            int newExponent = leadingTermDividend.getExponent() - leadingTermDivisor.getExponent();

            Term quotientTerm = new Term(newCoefficient, 'x', newExponent);
            quotientTerms.add(quotientTerm);

            Polynomial product = new Polynomial();
            product.add(quotientTerm);
            product = product.multiply(polynomial);

            remainderTerms = this.subtract(product).listTerms;
        }

        //return new quotientTerms
        return new Polynomial(quotientTerms);
    }

    public Term getLeadingTerm() {
        if (listTerms.isEmpty()) {
            throw new IllegalArgumentException("polynomial is null");
        }

        return listTerms.get(0);
    }


    @Override
    public String toString() {
        if (listTerms.isEmpty()) {
            return "0";
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = listTerms.size() - 1; i >= 0; i--) {
            stringBuilder.append(listTerms.get(i)).append("+");
        }
        stringBuilder.setLength(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }
}
