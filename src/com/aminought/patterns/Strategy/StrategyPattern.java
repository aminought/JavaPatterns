/**
* Паттерн Стратегия нужен в том случае, если нужно совершить некое действие из какого-то семейства.
* В процессе выполнения программы можно заменять один алгоритм другим.
*/

package com.aminought.patterns.Strategy;

public class StrategyPattern {
    public static void main(String[] args) {
        Context contextA = new Context(new ConcreteStrategyA());
        Context contextB = new Context(new ConcreteStrategyB());
        contextA.exec();
        contextB.exec();
    }
}

interface Strategy {
    void exec();
}

class ConcreteStrategyA implements Strategy {
    @Override
    public void exec() {
        System.out.println("ConcreteStrategyA");
    }
}

class ConcreteStrategyB implements Strategy {
    @Override
    public void exec() {
        System.out.println("ConcreteStrategyB");
    }
}

class Context implements Strategy {
    private Strategy strategy = null;
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void exec() {
        strategy.exec();
    }
}
