package model;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class MyStackTest {

    public MyStack<Person> setUpScenario1() {

        MyStack<Person> s = new MyStack<>();
        s.push(new Person("Gabriel", 2, 4));
        s.push(new Person("Sebastian", 1, 2));

        return s;
    }

    @Test
    void peek() {

        MyStack<Person> s = new MyStack<>();
        assertNull(s.peek());

        s = setUpScenario1();
        assertEquals("Sebastian", s.peek().getS().getName());
    }

    @Test
    void pop() {

        MyStack<Person> s = new MyStack<>();
        assertNull(s.pop());

        s = setUpScenario1();
        assertEquals("Sebastian", s.pop().getName());
        assertNotEquals("Sebastian", s.pop().getName());
    }

    @Test
    void push() {

        MyStack<Person> s = setUpScenario1();
        s.push(new Person("Santiago", 3, 8));

        assertEquals("Santiago", s.peek().getS().getName());
    }

    @Test
    void size() {

        MyStack<Person> s = new MyStack<>();
        assertEquals(0, s.size());

        s = setUpScenario1();
        assertNotEquals(0, s.size());
    }
}