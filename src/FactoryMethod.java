import java.util.ArrayList;

public class FactoryMethod {
    public static void main(String[] args) {
        Obj1Factory obj1Factory = new Obj1Factory();
        Obj2Factory obj2Factory = new Obj2Factory();
        Obj3Factory obj3Factory = new Obj3Factory();
        ArrayList<Obj> objs = new ArrayList<>();
        objs.add(obj1Factory.createObj());
        objs.add(obj2Factory.createObj());
        objs.add(obj3Factory.createObj());
        for(Obj o : objs) {
            o.info();
        }
    }
}

abstract class Obj {
    abstract public void info();
}

class Obj1 extends Obj {
    @Override
    public void info() {
        System.out.println("Obj1");
    }
}

class Obj2 extends Obj {
    @Override
    public void info() {
        System.out.println("Obj2");
    }
}

class Obj3 extends Obj {
    @Override
    public void info() {
        System.out.println("Obj3");
    }
}

abstract class Factory {
    public abstract Obj createObj();
}

class Obj1Factory extends Factory {
    @Override
    public Obj createObj() {
        return new Obj1();
    }
}

class Obj2Factory extends Factory {
    @Override
    public Obj createObj() {
        return new Obj2();
    }
}

class Obj3Factory extends Factory {
    @Override
    public Obj createObj() {
        return new Obj3();
    }
}
