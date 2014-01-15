package prueba1mc.model;

public class Number {

    private double numerator;
    private double denominator;

    public Number(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    private double getNumerator() {
        return numerator;
    }

    private double getDenominator() {
        return denominator;
    }

    public Number mult(Number number) {
        return new Number(number.getNumerator() * this.getNumerator(), number.denominator * this.getDenominator()).simplify();
    }

    public Number div(Number number) {
        return new Number(this.getNumerator() * number.getDenominator(), this.getDenominator() * number.getNumerator()).simplify();
    }

    public Number sum(Number number) {
        return new Number(this.getNumerator() * number.getDenominator() + number.getNumerator() * this.getDenominator(), this.getDenominator() * number.getDenominator()).simplify();
    }

    public Number sub(Number number) {
        return new Number(this.getNumerator() * number.getDenominator() - number.getNumerator() * this.getDenominator(), this.getDenominator() * number.getDenominator()).simplify();
    }

    public double aprox() {
        return this.getNumerator() / this.getDenominator();
    }

    public Number simplify() {
        double mcd = mcd();
        return new Number(this.getNumerator() / mcd, this.getDenominator() / mcd);
    }

    private double mcd() {
        double u = abs(this.getNumerator());
        double v = abs(this.getDenominator());
        if (v == 0) {
            return u;
        }
        double r;
        while (v != 0) {
            r = u % v;
            u = v;
            v = r;
        }
        return u;
    }

    private double abs(double number) {
        if (number < 0) {
            return -1 * number;
        } else {
            return number;
        }
    }

    @Override
    public String toString() {
        if (denominator == 0) {
            return "Math Error";
        }
        if (denominator == 1) {
            return numerator + "";
        }
        if (denominator == numerator) {
            return "1";
        }

        return String.format("%.2f %n", new Number(numerator, denominator).aprox());
    }
}
