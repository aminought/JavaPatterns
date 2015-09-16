/**
* Расширение функциональности объекта без изменения его внутренностей.
* Используется интерфейс с методом, который нужно добавить в объект, сам объект, реализующий этот интерфейс
* и абстрактный класс декоратора, от которого наследуются различные декораторы с конкретным поведением.
*/

package com.aminought.patterns.Decorator;

public class DecoratorPattern {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        c.do_it();
        System.out.println();
        Decorator d = new ConcreteDecorator(new ConcreteComponent());
        d.do_it();
    }
}

interface IComponent {
    void do_it();
}

class ConcreteComponent implements IComponent {
    @Override
    public void do_it() {
        System.out.println("ConcreteComponent");
    }
}

abstract class Decorator implements IComponent {
    protected IComponent component;

    public Decorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void do_it() {
        component.do_it();
    }
}

class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(IComponent c) {
        super(c);
    }

    @Override
    public void do_it() {
        super.do_it();
        System.out.println("Decorator1");
    }
}
