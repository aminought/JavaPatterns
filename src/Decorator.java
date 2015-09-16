// Расширение функциональности объекта без изменения его внутренностей.
// Используется интерфейс с методом, который нужно добавить в объект, сам объект, реализующий этот интерфейс
// и абстрактный класс декоратора, от которого наследуются различные декораторы с конкретным поведением.

public class Decorator {
    public static void main(String[] args) {
        ADecorator d = new Decorator1(new ConcreteComponent());
        d.do_it();
    }
}

interface IComponent {
    void do_it();
}

abstract class ADecorator implements IComponent {
    protected IComponent component;

    public ADecorator(IComponent component) {
        this.component = component;
    }

    @Override
    public void do_it() {
        component.do_it();
    }
}

class ConcreteComponent implements IComponent {
    @Override
    public void do_it() {
        System.out.println("ConcreteComponent");
    }
    public void info() {
        System.out.println("ConcreteComponent info");
    }
}

class Decorator1 extends ADecorator {
    public Decorator1(IComponent c) {
        super(c);
    }

    @Override
    public void do_it() {
        super.do_it();
        System.out.println("Decorator1");
    }
    public void getParameter() {
        System.out.println("#Decorator1");
    }
}
