package katas.largefact;

import java.math.BigInteger;
import java.util.stream.IntStream;

import static java.math.BigInteger.ONE;

public class LargeFactorial {

    private LargeFactorial(){}

    public static String factorial(int n) {
        BigInteger fact = ONE;
        for (int i = 1; i <= n; i++)
            fact = fact.multiply(BigInteger.valueOf(i));
        return fact.toString();
    }

    public static String factorialWithLambdas(int n) {
        return IntStream.rangeClosed(1, n)
                .mapToObj(BigInteger::valueOf)
                .reduce(ONE, BigInteger::multiply)
                .toString();
    }

}
