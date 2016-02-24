package com.lm.cats;

public final class HelloService {
    public static Hello find(int id) {
        return new Hello("sample", id);
    }
}
