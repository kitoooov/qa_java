package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {
    @Mock
    private Feline feline;

    private Cat cat;

    @Before
    public void setUp() {
        cat = new Cat(feline);
    }

    @Test
    public void shouldReturnMeowWhenGetSoundCalled() {

        String sound = cat.getSound();

        assertEquals("Мяу", sound);
    }

    @Test
    public void shouldReturnFoodWhenGetFoodCalled() throws Exception {

        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.eatMeat()).thenReturn(expectedFood);

        List<String> actualFood = cat.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void shouldCallEatMeatWhenGetFoodCalled() throws Exception {

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные"));

        cat.getFood();

        Mockito.verify(feline).eatMeat();
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenPredatorThrowsException() throws Exception {

        Mockito.when(feline.eatMeat()).thenThrow(
                new Exception("Не удалось получить еду")
        );

        cat.getFood();

    }
}