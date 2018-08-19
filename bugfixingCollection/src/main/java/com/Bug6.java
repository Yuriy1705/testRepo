package com;

import java.util.HashMap;
import java.util.Objects;

public class Bug6 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        MyClass first = new MyClass("a");
        MyClass second = new MyClass("a");

        hashMap.put(first, "test1");
        hashMap.put(second, "test2");//why we don't update first object with new value "test2"
        for (Object k : hashMap.keySet()) {
            System.out.println(hashMap.get(k));
        }
// Ссылочные обьекты Хещ код определяется по разному ( а когда переопределил основополагающие методу у ключа, то с одинаковыми полями он получает одинаковый ХешКод, поэтому просто перезатер прежнюю ячейку)


    }
}


class MyClass {

    private final String importantField;

    public MyClass(final String equalField) {
        this.importantField = equalField;
    }

    public String getEqualField() {
        return importantField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyClass myClass = (MyClass) o;
        return Objects.equals(importantField, myClass.importantField);
    }

    @Override
    public int hashCode() {

        return Objects.hash(importantField);
    }
}