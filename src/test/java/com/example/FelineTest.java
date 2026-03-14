package com.example;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FelineTest {

    private Feline feline;

    @Before
    public void setUp() {
        feline = new Feline();
    }

    @Test
    public void shouldReturnPredatorFoodWhenEatMeatCalled() throws Exception {

        List<String> food = feline.eatMeat();

        assertEquals(List.of("Животные", "Птицы", "Рыба"), food);
    }

    @Test
    public void shouldReturnFelineFamilyWhenGetFamilyCalled() {
        String family = feline.getFamily();

        assertEquals("Кошачьи", family);
    }

    @Test
    public void shouldReturnOneKittenWhenGetKittensCalled() {
        int kittens = feline.getKittens();

        assertEquals(1, kittens);
    }

}