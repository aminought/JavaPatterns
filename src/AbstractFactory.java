// Абстрактная фабрака применяется, если в приложении есть несколько групп объектов со схожим поведением, но разной
// реализацией. Для этого используется сама абстракная фабрика, от которой наследуются конкретные фабрики объектов
// для каждой группы и абстрактные объекты, от которых наследуются конкретные. Каждая конкретная фабрика создает
// конкретный продукт для своей группы.

import java.util.ArrayList;

abstract  class AbstractProduct {
    abstract void info();
}

abstract class AbstractProductA extends AbstractProduct {}
abstract class AbstractProductB extends AbstractProduct {}
abstract class AbstractProductC extends AbstractProduct {}

class ProductA1 extends AbstractProductA {
    @Override
    void info() { System.out.println("ProductA1"); }
}

class ProductB1 extends AbstractProductB {
    @Override
    void info() { System.out.println("ProductB1"); }
}

class ProductC1 extends AbstractProductC {
    @Override
    void info() { System.out.println("ProductC1"); }
}

class ProductA2 extends AbstractProductA {
    @Override
    void info() { System.out.println("ProductA2"); }
}

class ProductB2 extends AbstractProductB {
    @Override
    void info() { System.out.println("ProductB2"); }
}

class ProductC2 extends AbstractProductC {
    @Override
    void info() { System.out.println("ProductC2"); }
}

abstract class AbstractProductFactory {
    abstract AbstractProductA createConcreteProductA();
    abstract AbstractProductB createConcreteProductB();
    abstract AbstractProductC createConcreteProductC();
}

class ConcreteFactory1 extends AbstractProductFactory {
    @Override
    AbstractProductA createConcreteProductA() { return new ProductA1(); }

    @Override
    AbstractProductB createConcreteProductB() { return new ProductB1(); }

    @Override
    AbstractProductC createConcreteProductC() { return new ProductC1(); }
}

class ConcreteFactory2 extends AbstractProductFactory {
    @Override
    AbstractProductA createConcreteProductA() { return new ProductA2(); }

    @Override
    AbstractProductB createConcreteProductB() { return new ProductB2(); }

    @Override
    AbstractProductC createConcreteProductC() { return new ProductC2(); }
}

class Group {
    public ArrayList<AbstractProductA> la = new ArrayList<>();
    public ArrayList<AbstractProductB> lb = new ArrayList<>();
    public ArrayList<AbstractProductC> lc = new ArrayList<>();

    public Group(AbstractProductFactory factory) {
        la.add(factory.createConcreteProductA());
        lb.add(factory.createConcreteProductB());
        lc.add(factory.createConcreteProductC());
    }

    public void info() {
        for(AbstractProductA a : la) { a.info(); }
        for(AbstractProductB b : lb) { b.info(); }
        for(AbstractProductC c : lc) { c.info(); }
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        ConcreteFactory1 concreteFactory1 = new ConcreteFactory1();
        ConcreteFactory2 concreteFactory2 = new ConcreteFactory2();

        Group g1 = new Group(concreteFactory1);
        Group g2 = new Group(concreteFactory2);

        g1.info();
        System.out.println();
        g2.info();
    }
}
