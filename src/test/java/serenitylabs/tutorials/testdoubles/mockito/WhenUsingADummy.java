package serenitylabs.tutorials.testdoubles.mockito;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import serenitylabs.tutorials.testdoubles.Authoriser;
import serenitylabs.tutorials.testdoubles.System;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WhenUsingADummy {

    @Test
    @Disabled("Implement me, please ...")
    public void we_do_not_worry_about_the_value_it_returns_because_we_know_it_will_never_be_used() {

    }

    @Test
    public void we_make_it_return_a_null_so_that_it_does_not_get_used_accidentally() {
        /*
         * Mockito always returns a 'nice' value, so we son't get a null unless the method in question
         * returns a custom object
         *
         * https://github.com/mockito/mockito/wiki/FAQ#what-values-do-mocks-return-by-default
         */
    }
}
