package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParametrizedTest {

    private final String sex;
    private final boolean expectedHasMane;

    @Parameterized.Parameters(name = "sex={0}, expectedHasMane={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},
                {"Самка", false}
        });
    }

    public LionParametrizedTest(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Test
    public void shouldReturnCorrectManeValueWhenLionCreatedWithValidSex() throws Exception {

        Feline feline = new Feline();
        Lion lion = new Lion(sex, feline);

        boolean hasMane = lion.doesHaveMane();

        assertEquals(expectedHasMane, hasMane);
    }
}