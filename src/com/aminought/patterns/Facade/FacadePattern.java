/**
 * Фасад нужен для того, чтобы явно показать политику, присутствующую между классами. Позволяет скрыть сложность
 * системы.
 */

package com.aminought.patterns.Facade;

public class FacadePattern {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.exec();
    }
}

class Facade {
    private SubsystemA subsystemA = new SubsystemA();
    private SubsystemB subsystemB = new SubsystemB();
    private SubsystemC subsystemC = new SubsystemC();

    public void exec() {
        subsystemA.execA();
        subsystemB.execB();
        subsystemC.execC();
    }
}

class SubsystemA {
    public void execA() {
        System.out.println("execA");
    }
}

class SubsystemB {
    public void execB() {
        System.out.println("execB");
    }
}

class SubsystemC {
    public void execC() {
        System.out.println("execC");
    }
}
