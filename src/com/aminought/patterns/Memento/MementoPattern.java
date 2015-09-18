/**
 * Паттерн Хранитель позволяет зафиксировать и сохранить состояние объекта так, чтобы можно было восстановить его в
 * дальнейшем.
 */

package com.aminought.patterns.Memento;

public class MementoPattern {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State A");
        System.out.println(originator.getState());
        caretaker.setMemento(originator.saveState());

        originator.setState("State B");
        System.out.println(originator.getState());

        originator.restoreState(caretaker.getMemento());
        System.out.println(originator.getState());
    }
}

class Memento {
    private String state;

    public Memento(String state) {
        setState(state);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}

class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento saveState() {
        return new Memento(state);
    }

    public void restoreState(Memento memento) {
        setState(memento.getState());
    }
}

class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
