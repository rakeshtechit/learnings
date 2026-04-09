package com.test;

interface A {
    default String show() {
        return "A";
    }
}

interface B {
    default String show () {
        return "B";
    }
}

class C implements A,B {
    public String show() {
        return A.super.show();   // or B.super.show()  
    }
}


public class TestRandom {
    public static void main(String ...args) {
        System.out.println("Test Started");
    }
}