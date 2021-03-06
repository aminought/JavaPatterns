package com.aminought.patterns.Singleton;

/**
 * Самая простая реализация паттерна SingletonSimple, не работает в многопоточной среде
 */
class SingletonSimple {
    private static SingletonSimple instance = null;
    public static SingletonSimple getInstance() {
        if(instance == null) {
            instance = new SingletonSimple();
        }
        return instance;
    }
}

/**
 * Самая простая многопоточная реализация
 */
class SingletonSimpleThreadsafe {
    private static SingletonSimpleThreadsafe instance = new SingletonSimpleThreadsafe();
    private SingletonSimpleThreadsafe() {}
    public static SingletonSimpleThreadsafe getInstance() {
        return instance;
    }
}

/**
 * Мноопоточная реализация. Используется блокировка с двойной проверкой (Double-Checked Locking)
 */
class SingletonThreadsafe {
    private static volatile SingletonThreadsafe instance;
    private SingletonThreadsafe() {};

    public static SingletonThreadsafe getInstance() {
        if(instance == null) {
            synchronized (SingletonThreadsafe.class) {
                if(instance == null) {
                    instance = new SingletonThreadsafe();
                }
            }
        }
        return instance;
    }
}

public class SingletonPattern {
    public static void main(String[] args) {
        SingletonThreadsafe instance = SingletonThreadsafe.getInstance();
    }
}
