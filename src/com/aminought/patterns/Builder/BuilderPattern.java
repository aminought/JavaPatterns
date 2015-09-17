/**
 * Паттерн Строитель позволяет отделить поэтапный алгоритм построения сложного объекта от его внешнего представления
 * так, чтобы можно было построить разные объекты с помощью одного алгоритма.
 */

package com.aminought.patterns.Builder;

public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        director.setBuilder(new ConcreteBuilderA());
        director.constructProduct();
        Product product = director.getProduct();
        product.printInfo();
    }
}

class Product {
    private String partA = null;
    private String partB = null;
    private String partC = null;

    public void setPartA(String partA) {
        this.partA = partA;
    }

    public void setPartB(String partB) {
        this.partB = partB;
    }

    public void setPartC(String partC) {
        this.partC = partC;
    }

    public void printInfo() {
        System.out.printf("%s %s %s", partA, partB, partC);
    }
}

abstract class Builder {
    protected Product product;

    public void createProduct() {
        product = new Product();
    }

    public Product getProduct() {
        return product;
    }

    abstract public void buildPartA();
    abstract public void buildPartB();
    abstract public void buildPartC();
}

class ConcreteBuilderA extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("PartAA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("PartAB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("PartAC");
    }
}

class ConcreteBuilderB extends Builder {
    @Override
    public void buildPartA() {
        product.setPartA("PartBA");
    }

    @Override
    public void buildPartB() {
        product.setPartB("PartBB");
    }

    @Override
    public void buildPartC() {
        product.setPartC("PartBC");
    }
}

class Director {
    private Builder builder = null;

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }

    public void constructProduct() {
        builder.createProduct();
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
    }

    public Product getProduct() {
        return builder.getProduct();
    }
}
