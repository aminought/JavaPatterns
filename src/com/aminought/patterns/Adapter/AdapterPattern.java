// Используется, если имеется класс, который имеет несовместимый интерфейс. Для этого создается еще один итерфейс для
// доступа к этому классу и адаптер, который находится между интерфейсом и этим классом.

package com.aminought.patterns.Adapter;

class Class {
    public void printInfo() {
        System.out.println("Info");
    }
}

interface Interface {
    void info();
}

class Adapter implements Interface {
    private Class c = null;
    public Adapter(Class c) {
        this.c = c;
    }

    @Override
    public void info() {
        c.printInfo();
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Interface i = new Adapter(new Class());
        i.info();
    }
}
