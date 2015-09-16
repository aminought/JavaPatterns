// Паттерн Фабричный метод позволяет делегировать создание объектов другому классу, который будет сам решать, объект
// какого класса ему создавать.

package com.aminought.patterns.FactoryMethod;

import java.util.ArrayList;

public class FactoryMethodPattern {
    public static void main(String[] args) {
        ArrayList<Creator> creators = new ArrayList<>();
        creators.add(new ConcreteCreatorA());
        creators.add(new ConcreteCreatorB());
        creators.add(new ConcreteCreatorA());
        for(Creator c: creators) {
            Product p = c.factoryMethod();
            p.info();
        }
    }
}

interface Product {
    void info();
}

class ProductA implements Product {
    @Override
    public void info() {
        System.out.println("ProductA");
    }
}

class ProductB implements Product {
    @Override
    public void info() {
        System.out.println("ProductB");
    }
}

interface Creator {
    Product factoryMethod();
}

class ConcreteCreatorA implements Creator {
    @Override
    public Product factoryMethod() {
        return new ProductA();
    }
}

class ConcreteCreatorB implements Creator {
    @Override
    public Product factoryMethod() {
        return new ProductB();
    }
}
