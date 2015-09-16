/**
 * Абстрактная фабрака применяется, если в приложении есть несколько групп объектов со схожим поведением, но разной
 * реализацией. Для этого используется сама абстракная фабрика, от которой наследуются конкретные фабрики объектов
 * для каждой группы и абстрактные объекты, от которых наследуются конкретные. Каждая конкретная фабрика создает
 * конкретный продукт для своей группы.
 */

package com.aminought.patterns.AbstractFactory;

import java.util.ArrayList;

abstract class Product{
    abstract void info();
}

abstract class ProductA extends Product {}
abstract class ProductB extends Product {}
abstract class ProductC extends Product {}

class ProductA1 extends ProductA {
    @Override
    void info() { System.out.println("ProductA1"); }
}

class ProductB1 extends ProductB {
    @Override
    void info() { System.out.println("ProductB1"); }
}

class ProductC1 extends ProductC {
    @Override
    void info() { System.out.println("ProductC1"); }
}

class ProductA2 extends ProductA {
    @Override
    void info() { System.out.println("ProductA2"); }
}

class ProductB2 extends ProductB {
    @Override
    void info() { System.out.println("ProductB2"); }
}

class ProductC2 extends ProductC {
    @Override
    void info() { System.out.println("ProductC2"); }
}

abstract class AbstractFactory {
    abstract ProductA createConcreteProductA();
    abstract ProductB createConcreteProductB();
    abstract ProductC createConcreteProductC();
}

class ConcreteFactory1 extends AbstractFactory{
    @Override
    ProductA createConcreteProductA() { return new ProductA1(); }

    @Override
    ProductB createConcreteProductB() { return new ProductB1(); }

    @Override
    ProductC createConcreteProductC() { return new ProductC1(); }
}

class ConcreteFactory2 extends AbstractFactory {
    @Override
    ProductA createConcreteProductA() { return new ProductA2(); }

    @Override
    ProductB createConcreteProductB() { return new ProductB2(); }

    @Override
    ProductC createConcreteProductC() { return new ProductC2(); }
}

class Group {
    public ArrayList<ProductA> la = new ArrayList<>();
    public ArrayList<ProductB> lb = new ArrayList<>();
    public ArrayList<ProductC> lc = new ArrayList<>();

    public Group(AbstractFactory factory) {
        la.add(factory.createConcreteProductA());
        lb.add(factory.createConcreteProductB());
        lc.add(factory.createConcreteProductC());
    }

    public void info() {
        for(ProductA a : la) { a.info(); }
        for(ProductB b : lb) { b.info(); }
        for(ProductC c : lc) { c.info(); }
    }
}

public class AbstractFactoryPattern {
    public static void main(String[] args) {
        AbstractFactory concreteFactory1 = new ConcreteFactory1();
        AbstractFactory concreteFactory2 = new ConcreteFactory2();

        Group g1 = new Group(concreteFactory1);
        Group g2 = new Group(concreteFactory2);

        g1.info();
        System.out.println();
        g2.info();
    }
}
