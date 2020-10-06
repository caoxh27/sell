package com.imooc.sell;

public class StringTest {
    public static void main(String[] args) {
        String s = "Hello";
        s+=" word";
        System.out.println(s);
    }
}

//表面上看，好像是修改String类型对象s的值。其实不是，
//String s=“Hello”语句声明了一个可以指向String类型对象的引用，这个引用的名字为s，它指向了一个字符串常量“Hello”。
//s+=" world"并没有改变s所指向的对象（由于“Hello”是String类型的对象，而String又是不可变量），
//这句代码运行后，s指向了另外一个String类型的对象，该对象的内容为“Hello world”。
//原来的那个字符串常量“Hello”还存在与内存中，并没有被改变。