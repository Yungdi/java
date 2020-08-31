package com.example.demo;

import java.io.Closeable;
import java.util.List;

public interface IntersectionGenerics<R extends List<T> & Closeable, T> {
    R test();
}