/**
 * Паттерн Команда позволяет взаимодействовать с каким-либо действием как с объектом. Требуется Invoker (отправитель),
 * Receiver (получатель), сам объект, над которым происходит действие, и Client - объект, который создаёт экземпляр
 * командного объекта.
 */

package com.aminought.patterns.Command;

public class CommandPattern {
    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Invoker invoker = new Invoker(new ConcreteCommandA(receiver), new ConcreteCommandB(receiver));
        invoker.doCommandA();
        invoker.doCommandB();
    }
}

class Invoker {
    private Command commandA = null;
    private Command commandB = null;

    public Invoker(Command A, Command B) {
        commandA = A;
        commandB = B;
    }

    public void doCommandA() {
        commandA.doAction();
    }

    public void doCommandB() {
        commandB.doAction();
    }
}

abstract class Command {
    protected Receiver receiver = null;
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    abstract void doAction();
}

class ConcreteCommandA extends Command {
    public ConcreteCommandA(Receiver receiver) {
        super(receiver);
    }

    @Override
    void doAction() {
        receiver.doActionA();
    }
}

class ConcreteCommandB extends Command {
    public ConcreteCommandB(Receiver receiver) {
        super(receiver);
    }

    @Override
    void doAction() {
        receiver.doActionB();
    }
}

class Receiver {
    public void doActionA() {
        System.out.println("Action A");
    }
    public void doActionB() {
        System.out.println("Action B");
    }
}
