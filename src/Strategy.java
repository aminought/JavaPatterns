// Паттерн Стратегия нужен в том случае, если нужно совершить некое действие из какого-то семейства.
// В процессе выполнения программы можно заменять один алгоритм другим.

public class Strategy {
    public static void main(String[] args) {
        Actioner action = new Actioner(new ConcreteAction2());
        action.doAction();
    }
}

interface Action {
    void doAction();
}

class ConcreteAction1 implements Action {
    @Override
    public void doAction() {
        System.out.println("ConcreteAction1");
    }
}

class ConcreteAction2 implements Action {
    @Override
    public void doAction() {
        System.out.println("ConcreteAction2");
    }
}

class Actioner implements Action {
    private Action action = null;
    public Actioner(Action action) {
        this.action = action;
    }

    @Override
    public void doAction() {
        action.doAction();
    }
}
