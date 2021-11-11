package ch.hslu.oop.SW07;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    public void testForename() {
        assertEquals("Martin", new Person("Höger", "Martin").getFirstName());
    }

    @Test
    public void testSurname() {
        assertEquals("Höger", new Person("Höger", "Martin").getLastName());
    }

    @Test
    public void testDefaultId() {
        assertEquals(1, new Person("Default", "ID").getId());
    }

    @Test
    public void testId() {
        assertEquals(2, new Person(2, "Test", "ID").getId());
    }

    //equals
    @Test
    public void testEqualsTrue() {
        assertTrue(new Person("Höger", "Martin").equals(new Person("Höger", "Martin")));
    }

    @Test
    public void testEqualsFalse() {
        assertFalse(new Person(0,"Höger", "Martin").equals(new Person(1,"Höger", "Martin")));
    }

    //hashCode
    @Test
    public void testHash() {
        assertEquals(new Person("Höger", "Martin").hashCode(), new Person("Höger", "Martin").hashCode());
    }

    //compareTo
    @Test
    public void testCompareToTrue() {
        assertEquals(0, new Person(1, "Höger", "Martin").compareTo(new Person(1, "Höger", "Martin")));
    }

    @Test
    public void testCompareToHigher() {
        assertEquals(1, new Person(2, "Höger", "Martin").compareTo(new Person(1, "Höger", "Martin")));
    }

    @Test
    public void testCompareToLower() {
        assertEquals(-1, new Person(1, "Höger", "Martin").compareTo(new Person(2, "Höger", "Martin")));
    }

    //equalsVerifier - doesn't work
    @Test
    public void testEqualsVerifier(){
        EqualsVerifier.forClass(Person.class).withOnlyTheseFields("id").verify();
    }

}