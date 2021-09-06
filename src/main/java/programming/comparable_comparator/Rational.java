package programming.comparable_comparator;

/**
 * 两个分数作比较
 *
 * @author lyq_power
 * @date 2019/11/22 20:42 11s
 */
public class Rational implements Comparable<Rational> {

    private int numerator = 0;
    private int denominator = 0;

    Rational(int numerator, int denominator) {
        this.denominator = denominator;
        this.numerator = numerator;
        if (this.denominator == 0 && this.numerator == 0) throw new RuntimeException("分子分母不可同为0");
    }

    public int gcd(int a, int b) {
        return (a % b == 0 ? b : gcd(b, a % b));
    }

    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    @Override
    public int compareTo(Rational o) {
        if (this.denominator == 0 && o.denominator != 0) {
            return 1;
        } else if (this.denominator != 0 && o.denominator == 0) {
            return -1;
        } else if (this.denominator == 0) {
            return 0;
        } else {
            int lcm = lcm(this.denominator, o.denominator);
            int lcm1 = lcm / this.denominator;
            int lcm2 = lcm / o.denominator;
            int num1 = this.numerator * lcm1;
            int num2 = o.numerator * lcm2;
            return Integer.compare(num1, num2);
        }
    }
}
