package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FelineParametrizedTest {

    private final int kittensCount;

    @Parameterized.Parameters(name = "kittensCount={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {0},
                {1},
                {3},
                {10}
        });
    }
    public FelineParametrizedTest(int kittensCount) {
        this.kittensCount = kittensCount;
    }

    @Test
    public void shouldReturnSameKittensCountWhenGetKittensWithParamCalled() {
        Feline feline = new Feline();

        int actualKittens = feline.getKittens(kittensCount);

        assertEquals(kittensCount, actualKittens);
    }
}