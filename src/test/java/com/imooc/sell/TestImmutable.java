package com.imooc.sell;

import java.util.Date;

class WrongImmutableClass {
    private Date d;

    public WrongImmutableClass(Date dp) {
        this.d = dp;
    }

    public void printState(){
        System.out.println("WrongImmutableClass d = " + d);
    }
}

class RightImmutableClass {
    private Date d;

    public RightImmutableClass(Date dp) {
        this.d = (Date) dp.clone();     //解除与d的应用关系
    }

    public void printState(){
        System.out.println("RightImmutableClass d = " + d);
    }

    public Date getDate() {
        return (Date) d.clone();        //解除与d的应用关系
    }
}

public class TestImmutable{
    public static void main(String[] args) {
        Date d1 = new Date();
        Date d2 = new Date();

        WrongImmutableClass wImmuC = new WrongImmutableClass(d1);
        wImmuC.printState();
        d1.setMonth(5);
        wImmuC.printState();
        //需要说明的是，由于Date的对象的状态是可以被改变的，而 WrongImmutableClass 保存了Date类型对象的引用，
        //被引用的对象的状态改变的时候会导致 WrongImmutableClass 对象状态的改变。

        RightImmutableClass rImmuC = new RightImmutableClass(d2);
        rImmuC.printState();
        d2.setMonth(5);
        rImmuC.printState();

    }
}