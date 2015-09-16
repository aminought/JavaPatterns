/**
 * Посредник. Этот паттерн служит для ослабления связности классов, избавляя объекты от необходимости явно ссылаться
 * друг на друга.
 */

package com.aminought.patterns.Mediator;

abstract class Colleague {
    protected Mediator mediator = null;
    public Colleague(Mediator m) {
        mediator = m;
    }
    public void send(String message) {
        mediator.send(message, this);
    }
    abstract public void ring(String msg);
}

class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator m) {
        super(m);
    }
    @Override
    public void ring(String msg) {
        System.out.println("ConcreteColleagueA gets message: " + msg);
    }
}

class ConcreteColleagueB extends Colleague {
    public ConcreteColleagueB(Mediator m) {
        super(m);
    }
    @Override
    public void ring(String msg) {
        System.out.println("ConcreteColleagueB gets message: " + msg);
    }
}

abstract class Mediator {
    abstract public void send(String message, Colleague src);
}

class ConcreteMediator extends Mediator {
    private Colleague colleagueA = null;
    private  Colleague colleagueB = null;
    public void setCollegueA(Colleague a) {
        colleagueA = a;
    }
    public void setCollegueB(Colleague b) {
        colleagueB = b;
    }
    @Override
    public void send(String message, Colleague src) {
        if(src.equals(colleagueA)) {
            colleagueB.ring(message);
        } else {
            colleagueA.ring(message);
        }
    }
}

public class MediatorPattern {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();
        Colleague colleagueA = new ConcreteColleagueA(mediator);
        Colleague colleagueB = new ConcreteColleagueB(mediator);
        mediator.setCollegueA(colleagueA);
        mediator.setCollegueB(colleagueB);
        colleagueA.send("How are you?");
        colleagueB.send("Fine, thanks.");
    }
}

