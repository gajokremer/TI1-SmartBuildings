package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyQueueTest {

    public MyQueue<Person> setUpScenario1() {

        return new MyQueue<>();
    }

    public MyQueue<Person> setUpScenario2() {

        MyQueue<Person> al = new MyQueue<>();
        al.add(new Person("Gabriel", 2, 4));
        al.add(new Person("Sebastian", 1, 2));

        return al;
    }

    @Test
    void add() {

        MyQueue<Person> q =setUpScenario1();
        Person p1 = new Person("Gabriel", 2, 4);
        q.add(p1);
        assertEquals(p1, q.getHead().getQ());


        Person p2 = new Person("Sebastian", 1, 2);
        q.add(p2);
        assertNotEquals(p2, q.getHead().getQ());
    }

    @Test
    void element() {

        MyQueue<Person> al = setUpScenario1();
        assertNull(al.element());

        al = setUpScenario2();
        assertEquals("Gabriel", al.element().getName());


    }
}