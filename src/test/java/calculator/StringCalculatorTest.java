package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {
    private final StringCalculator cal = new StringCalculator();

    @Test
    void emptyStringShouldReturn0() {
        int returnValue = cal.add("");
        assertThat(returnValue == 0);
    }

    @Test
    void givenTwoValuesWithCommaSeparationShouldReturnSum() {
        int actual1 = cal.add("1,2");
        int actual2 = cal.add("4,6");
        assertThat(actual1 == 3);
        assertThat(actual2 == 10);
    }

}