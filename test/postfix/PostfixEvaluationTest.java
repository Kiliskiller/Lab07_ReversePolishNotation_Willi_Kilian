package postfix;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import stack.Underflow;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;


public class PostfixEvaluationTest {
    Postfix postfix = new Postfix();

    public static Stream<Arguments> testCases() {
        Stream<Object[]> testCases = TestCases.allTestCases();
        return testCases.map(a -> arguments(a[0], a[2], a[3]));
    }

    @ParameterizedTest
    @MethodSource("testCases")
    public void testEvaluatePostfix(String comment, String postfixStr,
                                    double result) throws Underflow {
        assertEquals(result,
                //postfix.evaluate(postfixStr),
                0.0,
                comment + " (postfix was: " + postfixStr + ")");

    }

}
