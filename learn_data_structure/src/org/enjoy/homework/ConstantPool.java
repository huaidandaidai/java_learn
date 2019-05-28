package org.enjoy.homework;

public class ConstantPool {
    public static void main(String[] args) {
        String b = "享学";
        String a = b + "课堂";
        System.out.println(a.intern() == a);
//        String a ="a";
//        String b ="b";
//        String c="c";
//        String d= a+b+c;
//        d.intern();
//        String e ="abc";
//        String f =new String("abc");
//        System.out.println(d == e);
//        System.out.println(d == f);
//        System.out.println(e == f);
//        System.out.println(d.intern() == d);
//        System.out.println(d.intern() == e);
//        System.out.println(d.intern() == f);
    }
}
