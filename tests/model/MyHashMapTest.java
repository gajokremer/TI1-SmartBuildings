package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {

//    private MyHashMap<Integer, Person> hm;

    public MyHashMap<Integer, Person> setUpScenario1() {

        return new MyHashMap<>();
    }

    public MyHashMap<Integer, Person> setUpScenario2() {

        MyHashMap<Integer, Person> intBuild = new MyHashMap<>();

        intBuild.put(1, new Person("Gabriel", 2 , 4));
        intBuild.put(2, new Person("Sebastian", 1 , 2));
        intBuild.put(3, new Person("Santiago", 3 , 8));

        return intBuild;
    }

    public MyHashMap<Integer, Building> setUpScenario3() {

        MyHashMap<Integer, Building> intBuild = new MyHashMap<>();

        intBuild.put(5, new Building('A'));
        intBuild.put(10, new Building('B'));
        intBuild.put(15, new Building('C'));
        intBuild.put(20, new Building('D'));
        intBuild.put(25, new Building('E'));

        return intBuild;
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

        MyHashMap<Integer, Building> intBuild = setUpScenario3();

        assertEquals('A', intBuild.get(5).getId());
    }

    @Test
    void containsKey() {

        MyHashMap<Integer, Person> intPers = setUpScenario2();

        assertTrue(intPers.containsKey(1));

        MyHashMap<Integer, Building> intBuild = setUpScenario3();

        assertFalse(intBuild.containsKey(30));
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


        MyHashMap<Integer, Building> intBuild = setUpScenario3();
//        assertEquals('A', intBuild.get(5).getId());
        assertNull(intBuild.get(100));

        intBuild.replace(100, new Building('Z'));
    }

    @Test
    void size() {

        MyHashMap<Integer, Person> intPers = setUpScenario1();

        assertEquals(0, intPers.size());


        MyHashMap<Integer, Building> intBuild = setUpScenario3();
        assertNotEquals(0, intBuild.size());
    }
}