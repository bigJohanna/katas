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
    @ValueSource(strings = {"", " ", "r", "one", "2,y3", "@", "1,\\n"})
    void givenInvaldInputShouldReturn0(String param) {
        int actual = cal.add(param);
        assertThat(actual).isEqualTo(0);
    }

    @Test
    void givenInputWithNewLineAsSeparatorShouldReturnSum() {
        assertThat(cal.add("1\n2,3")).isEqualTo(6);
    }

    @Test
    void name() {
    }
}