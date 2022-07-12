package com.simple4h.sample.pattern.bulider;

/**
 * TODO:
 *
 * @author Simple4H
 */
public class Test {

    public static void main(String[] args) {
        System.out.println(new PrimaryBuilder().construct().toString());
        System.out.println(new kindergartenBuilder().construct().toString());

    }
}
