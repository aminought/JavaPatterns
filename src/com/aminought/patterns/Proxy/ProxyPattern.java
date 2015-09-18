/**
 * Существует несколько видов Заместителей. В данном случае реализован протоколирующий заместитель, который заменяет
 * реальный объект, выполняет его методы и ведёт лог событий.
 */

package com.aminought.patterns.Proxy;

public class ProxyPattern {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.execB();
        subject.execC();
        subject.execA();
    }
}

interface Subject {
    void execA();
    void execB();
    void execC();
}

class RealSubject implements Subject {
    @Override
    public void execA() { }

    @Override
    public void execB() { }

    @Override
    public void execC() { }
}


class Proxy implements Subject {
    private Subject realSubject;
    @Override
    public void execA() {
        createInstance();
        realSubject.execA();
        System.out.println("execA");
    }

    @Override
    public void execB() {
        createInstance();
        realSubject.execB();
        System.out.println("execB");
    }

    @Override
    public void execC() {
        createInstance();
        realSubject.execC();
        System.out.println("execC");
    }

    private void createInstance() {
        if(realSubject == null) {
            realSubject = new RealSubject();
        }
    }
}

