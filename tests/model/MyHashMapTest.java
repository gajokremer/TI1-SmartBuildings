package model;

import org.junit.jupiter.api.Test;

import java.awt.geom.QuadCurve2D;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

//    private MyHashMap<Integer, Person> hm;

    public MyHashMap<Integer, Person> setUpScenario1() {

        return new MyHashMap<>();
    }

    public MyHashMap<Integer, Person> setUpScenario2() {

        MyHashMap<Integer, Person> intPers = new MyHashMap<>();

        intPers.put(1, new Person("Gabriel", 2 , 4));
        intPers.put(2, new Person("Sebastian", 1 , 2));
        intPers.put(3, new Person("Santiago", 3 , 8));

        return intPers;
    }

    public MyHashMap<Integer, MyQueue<Person>> setUpScenario3() {

        MyHashMap<Integer, MyQueue<Person>> intPeople = new MyHashMap<>();

        MyQueue<Person> q1 = new MyQueue<>();
        q1.add(new Person("Gabriel", 2, 4));
        q1.add(new Person("Sebastian", 1, 2));
        MyQueue<Person> q2 = new MyQueue<>();
        q2.add(new Person("Santiago", 3, 8));
        MyQueue<Person> q3 = new MyQueue<>();
        q3.add(new Person("Daniel", 5, 5));

        intPeople.put(10, q1);
        intPeople.put(20, q2);
        intPeople.put(30, q3);

        return intPeople;
    }

    @Test
    void put() {

        MyHashMap<Integer, Person> intPers = setUpScenario1();


        assertEquals(0, intPers.size());

        Person p1 = new Person("Gabriel", 2, 4);
        intPers.put(1, p1);

        assertNotEquals(0, intPers.size());


        intPers = new MyHashMap<>();

        for(int i = 0; i < 1000; i++) {

            String name = "Person " + i;
            Person n = new Person(name, i, 0);

            intPers.put(1, n);
        }

        assertNotEquals(1000, intPers.size());
    }

    @Test
    void get() {

        MyHashMap<Integer, Person> intPers = setUpScenario2();

        intPers.put(1, null);
        assertNotNull(intPers.get(1));

        setUpScenario2();

        assertNotNull(intPers.get(1));
        assertNotNull(intPers.get(2));

        MyHashMap<Integer, MyQueue<Person>> intPeople = setUpScenario3();
//
        assertEquals("Gabriel", intPeople.get(10).getHead().getQ().getName());
    }

    @Test
    void containsKey() {

        MyHashMap<Integer, Person> intPers = setUpScenario2();

        assertTrue(intPers.containsKey(1));

        MyHashMap<Integer, MyQueue<Person>> intPeople = setUpScenario3();

        assertTrue(intPeople.containsKey(30));
    }

    @Test
    void containsValue() {

        MyHashMap<Integer, Person> intPers = setUpScenario2();

        assertFalse(intPers.containsValue(new Person("Juan", 6, 5)));

//        MyHashMap<Integer, Building> intBuild = setUpScenario3();
//
//        assertFalse(intBuild.containsValue());
    }

    @Test
    void replace() {

        MyHashMap<Integer, Person> intPers = setUpScenario2();
        assertEquals("Gabriel", intPers.get(1).getName());

        intPers.replace(1, new Person("Daniel", 5, 5));

        assertNotEquals("Gabriel", intPers.get(1).getName());


        MyHashMap<Integer, MyQueue<Person>> intPeople = setUpScenario3();
//        assertEquals('A', intBuild.get(5).getId());
        assertNull(intPeople.get(100));

        intPeople.replace(100, new MyQueue<>());
    }

    @Test
    void size() {

        MyHashMap<Integer, Person> intPers = setUpScenario1();

        assertEquals(0, intPers.size());


        MyHashMap<Integer, MyQueue<Person>> intPeople = setUpScenario3();
        assertNotEquals(0, intPeople.size());
    }
}