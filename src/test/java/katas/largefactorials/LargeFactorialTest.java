package katas.largefactorials;

import katas.largefact.LargeFactorial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LargeFactorialTest {


    @Test
    public void BasicTests() {
        assertEquals("1", LargeFactorial.factorial(1));
        assertEquals("120", LargeFactorial.factorial(5));
        assertEquals("362880", LargeFactorial.factorial(9));
        assertEquals("1307674368000", LargeFactorial.factorial(15));
    }

    @Test
    public void BasicTestsWithLambdas() {
        assertEquals("1", LargeFactorial.factorialWithLambdas(1));
        assertEquals("120", LargeFactorial.factorialWithLambdas(5));
        assertEquals("362880", LargeFactorial.factorialWithLambdas(9));
        assertEquals("1307674368000", LargeFactorial.factorialWithLambdas(15));
    }

}
