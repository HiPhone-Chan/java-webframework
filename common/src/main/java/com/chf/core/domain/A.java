package com.chf.core.domain;

import com.chf.core.annotation.MyAnno;

@MyAnno
public class A {

    private A a;

    private String str;

    public A(String str) {
        this.str = str;
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public void op() {
        System.out.println(str);
    }

    @Override
    public String toString() {
        return "A [a=" + a + ", str=" + str + "]";
    }

}
