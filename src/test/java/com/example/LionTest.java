package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    private Feline feline;

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenSexIsInvalid() throws Exception {
        // Given: невалидное значение пола
        String invalidSex = "Кошечка";

        new Lion(invalidSex, feline);

    }

    @Test
    public void shouldReturnKittensCountWhenGetKittensCalled() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);

        int kittens = lion.getKittens();

        assertEquals(3, kittens);
    }

    @Test
    public void shouldCallFelineGetKittensWhenGetKittensCalled() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Самец", feline);

        lion.getKittens();

        Mockito.verify(feline).getKittens();
    }

    @Test
    public void shouldReturnFoodWhenGetFoodCalled() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        Lion lion = new Lion("Самец", feline);

        List<String> actualFood = lion.getFood();

        assertEquals(expectedFood, actualFood);
    }

    @Test
    public void shouldCallFelineGetFoodWithPredatorWhenGetFoodCalled() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные"));
        Lion lion = new Lion("Самец", feline);

        lion.getFood();

        Mockito.verify(feline).getFood("Хищник");
    }
}