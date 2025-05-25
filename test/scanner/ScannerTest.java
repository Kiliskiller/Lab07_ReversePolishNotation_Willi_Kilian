package scanner;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import postfix.TestCases;
import stack.Underflow;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ScannerTest {
    public static Stream<Arguments> testCases() {
        return TestCases.allTestCases()
                .filter(a -> a.length > 4)
                .map(a -> arguments(a[1], a[4]));
    }


    @ParameterizedTest
    @MethodSource("testCases")
    public void testScanner(String infix, String tokenizedString) throws Underflow {
        String[] expected = tokenizedString.split(" ");
        myScanner scanner = new myScanner(infix);
        String[]actual = scanner.getToken();
        assertArrayEquals(expected,actual);
    }

}
