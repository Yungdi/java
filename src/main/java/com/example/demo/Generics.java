package com.example.demo;

public interface Generics<T> {
    <R> R test(T t);
}