package model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.*;

class MyPriorityQueueTest {

    public MyPriorityQueue<Person> setUpScenario1() {

        MyPriorityQueue<Person> pq = new MyPriorityQueue<>();
        pq.offer(new Person("Gabriel", 2, 4));

        return pq;
    }

    public MyPriorityQueue<Person> setUpScenario2() {

        MyPriorityQueue<Person> pq = new MyPriorityQueue<>();
        pq.offer(new Person("Gabriel", 2, 4));
        pq.offer(new Person("Sebastian", 1, 2));
        pq.offer(new Person("Santiago", 3, 8));

        return pq;
    }

    @Test
    void peek() {

        MyPriorityQueue<Person> pq = new MyPriorityQueue<>();

        assertNull(pq.peek());


        pq = setUpScenario1();

        assertEquals("Gabriel", pq.peek().getP().getName());
    }

    @Test
    void offer() {

        MyPriorityQueue<Person> pq = new MyPriorityQueue<>();

        assertNull(pq.getRoot());

        Person p = new Person("Gabriel", 2, 4);
        pq.offer(p);
        assertSame(p, pq.getRoot().getP());

        Person p1 = new Person("Sebastian", 1, 2);
        pq.offer(p1);
        assertNotSame(p1, pq.getRoot().getP());
    }

    @Test
    void size() {

        MyPriorityQueue<Person> pq = setUpScenario1();
        assertEquals(1, pq.size());

        pq = setUpScenario2();
        assertEquals(3, pq.size());
    }

    @Test
    void poll() {

        MyPriorityQueue<Person> pq = setUpScenario1();
        assertNotNull(pq.peek());
        pq.poll();
        assertNull(pq.peek());


        pq = setUpScenario2();
        assertEquals("Gabriel", pq.poll().getName());
        assertEquals("Santiago", pq.peek().getP().getName());

    }
}