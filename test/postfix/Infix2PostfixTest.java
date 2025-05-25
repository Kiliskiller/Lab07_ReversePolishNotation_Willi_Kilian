package postfix;


import java.util.stream.Stream;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stack.Underflow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class Infix2PostfixTest {

    Infix infix = new Infix();

    public static Stream<Arguments> testCases() {
        Stream<Object[]> testCases = TestCases.allTestCases();
        return testCases.map(a -> arguments(a[0], a[1], a[2]));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testInfixToPostfix(String message, String infixStr, String postfix) throws Underflow {
//        assertEquals(postfix,
//                infix.toPostfix(infixStr), message + " (infix was: " + infix + ")");

    }

}
