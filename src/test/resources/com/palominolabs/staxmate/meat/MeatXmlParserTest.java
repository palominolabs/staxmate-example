package com.palominolabs.staxmate.meat;

import org.junit.Before;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public final class MeatXmlParserTest {

    private Food food;

    @Before
    public void setUp() throws XMLStreamException {
        food = new MeatXmlParser().parse(this.getClass().getResourceAsStream("/sample.xml"));
    }

    @Test
    public void testAnimals() throws XMLStreamException {
        List<Animal> animals = food.getAnimals();
        assertEquals(3, animals.size());

        assertEquals("Chicken", animals.get(2).getName());
    }

    @Test
    public void testCowMeats() {
        Animal cow = food.getAnimals().get(1);

        List<Meat> meats = cow.getMeats();
        assertEquals(3, meats.size());

        assertEquals("Brisket", meats.get(1).getName());
    }

    @Test
    public void testVegetables() {
        List<Vegetable> vegetables = food.getVegetables();

        assertEquals(3, vegetables.size());

        assertEquals("Kale", vegetables.get(1).getName());
    }

    @Test
    public void testBrusselsSproutsPreparations() {
        Vegetable brusselsSprouts = food.getVegetables().get(0);

        assertEquals(3, brusselsSprouts.getPreparations().size());
        assertEquals("Roasted", brusselsSprouts.getPreparations().get(1));
    }
}
