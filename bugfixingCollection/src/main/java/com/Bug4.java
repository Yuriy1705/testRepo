package com;


import java.util.Objects;

public class Bug4 {
    public static void main(String[] args) {
        Parent parent1 = new Parent();//AGE = 30
        Parent parent2 = new Child();//AGE = 10

        boolean equals = parent2.equals(parent1);
        System.out.println(equals);


        //why it's true? || Answer ==> Because (instanceof)
        // Как я прочитал, у каждого обьекта типа сущности должны быть переопределенны важные методы))))
    }
}


class Parent {
    int age = 30;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Parent)) return false;
        Parent parent = (Parent) o;
        return age == parent.age;
    }

}

class Child extends Parent {
    int age = 10;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Child child = (Child) o;
        return age == child.age;
    }

    @Override
    public int hashCode() {

        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Child{" +
                "age=" + age +
                '}';
    }
}