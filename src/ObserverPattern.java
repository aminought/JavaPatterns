// Паттерн Наблюдатель используется, если мы имеем объект рассылающий сообщения и не менее одного-двух получателей
// этих сообщений.

import java.util.ArrayList;

interface Observable {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}

interface Observer {
    void handleEvent();
}

class ConcreteObservable implements Observable {
    private ArrayList<Observer> observers = new ArrayList<>();
    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer o: observers) {
            o.handleEvent();
        }
    }
}

class ConcreteObserver implements Observer {
    @Override
    public void handleEvent() {
        System.out.println("Event handled");
    }
}

public class ObserverPattern {
    public static void main(String[] args) {
        Observable observable = new ConcreteObservable();
        Observer observer1 = new ConcreteObserver();
        Observer observer2 = new ConcreteObserver();
        observable.addObserver(observer1);
        observable.addObserver(observer2);
        observable.notifyObservers(); // обычно выполняется внутри наблюдаемого объекта при изменении состояния
        observable.removeObserver(observer1);
        observable.removeObserver(observer2);
    }
}
