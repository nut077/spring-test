package com.nutfreedom.springtest.spike;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class HamcrestMatchersTest {
    @Test
    public void learning() {
        List<Integer> numbers = Arrays.asList(12, 20, 50);
        assertThat(numbers, hasSize(3));
        assertThat(numbers, hasItems(20, 50));
        assertThat(numbers, everyItem(greaterThan(10)));
        assertThat(numbers, everyItem(lessThan(100)));

        assertThat("", isEmptyString());
        assertThat("ABCDE", startsWith("AB"));
        assertThat("ABCDE", endsWith("E"));
        assertThat("ABCDE", containsString("BC"));
    }

    @Test
    public void learning2() {
        List<Integer> numbers = Arrays.asList(12, 20, 50);
        assertThat(numbers).hasSize(3)
                .contains(20, 50)
                .allMatch(number -> number > 10)
                .allMatch(number -> number < 100)
                .noneMatch(number -> number < 0);

        assertThat("").isEmpty();
        assertThat("ABCDE").contains("AB")
                .startsWith("AB")
                .endsWith("E");
    }
}
