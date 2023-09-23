package dev.lpa;

@FunctionalInterface  //add this annotation to make sure that this is a functional interface
public interface Operation<T> {

    T operate(T value1, T value2);
}
