package com.example;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {

    private Animal animal;

    @Before
    public void setUp() {
        animal = new Animal();
    }

    @Test(expected = Exception.class)
    public void shouldThrowExceptionWhenAnimalKindIsUnknown() throws Exception {
        String unknownKind = "Птица";

        animal.getFood(unknownKind);

    }

    @Test
    public void shouldReturnFamilyWhenGetFamilyCalled() {

        String family = animal.getFamily();

        assertEquals(
                "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи",
                family
        );
    }
}
