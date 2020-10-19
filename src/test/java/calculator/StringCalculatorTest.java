package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    private final StringCalculator cal = new StringCalculator();

    @Test
    void givenTwoValuesWithCommaSeparationShouldReturnSum() {
        assertThat(cal.add("1,2")).isEqualTo(3);

    }

    @Test
    void givenAStringWithUnknownAmountOfNumbersShouldReturnSum() {
        assertThat(cal.add("2,3,4,5,6")).isEqualTo(20);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "r", "one", "2,y3", "@", "1,\n"})
    void givenInvaldInputShouldReturn0(String param) {
        assertThatExceptionOfType(NumberFormatException.class)
                .isThrownBy(()-> cal.add(param));
    }

    @Test
    void givenInputWithNewLineAsSeparatorShouldReturnSum() {
        assertThat(cal.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void givenTwoBackslashFirstInInputSetCustomDelimeter() {
        assertThat(cal.add("//;\n1;2")).isEqualTo(3);
    }

    @Test
    void givenNegativeNumbersThrowException() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->cal.add("-1,-2,4"))
                .withMessage("negatives not allowed,-1,-2");
    }

    @Test
    void numbersGt1000IsIgnored() {
        assertThat(cal.add("2,1001")).isEqualTo(2);
    }

    @Test
    void delimetersCanBeOfAnyLength() {
        assertThat(cal.add("//[***]\n1***2***3")).isEqualTo(6);
    }
}