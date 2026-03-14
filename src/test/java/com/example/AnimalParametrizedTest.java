package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class AnimalParametrizedTest {

    private final String animalKind;

    private final List<String> expectedFood;

    @Parameterized.Parameters(name = "animalKind={0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        });
    }

    public AnimalParametrizedTest(String animalKind, List<String> expectedFood) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
    }

    @Test
    public void shouldReturnFoodWhenAnimalKindIsValid() throws Exception {
        Animal animal = new Animal();

        List<String> actualFood = animal.getFood(animalKind);

        assertEquals(expectedFood, actualFood);
    }
}