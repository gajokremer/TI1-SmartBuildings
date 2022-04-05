package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

//    private MyArrayList<Building> al;

    public MyArrayList<Building> setUpScenario1() {

        return new MyArrayList<>();
    }

    public MyArrayList<Building> setUpScenario2() {

        MyArrayList<Building> al = new MyArrayList<>();

        al.add(new Building('A'));
//        al.add(new Building('B'));

        return al;
    }

    public MyArrayList<Building> setUpScenario3() {

        MyArrayList<Building> al = new MyArrayList<>();

        al.add(new Building('A'));
        al.add(new Building('B'));

        return al;
    }

    @Test
    void add() {

        MyArrayList<Building> al = setUpScenario1();
        al.add(new Building('A'));

        assertEquals(1, al.size());


        al = setUpScenario2();
        assertEquals(1, al.size());
        al.add(new Building('B'));
        assertNotEquals(1, al.size());
//        assertEquals(10, al.size());
    }

    @Test
    void removeAll() {

        MyArrayList<Building> al = setUpScenario3();
        assertEquals(2, al.size());

        al.removeAll();

        assertEquals(0, al.size());
    }

    @Test
    void size() {

        MyArrayList<Building> al = setUpScenario1();
        assertEquals(0, al.size());

        al = setUpScenario2();
        assertEquals(1, al.size());

        al = setUpScenario3();
        assertEquals(2, al.size());
    }

    @Test
    void get() {
    }
}