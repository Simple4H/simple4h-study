package com.simple4h.common.util;

/**
 * author Create By Simple4H
 * date 2020-10-22 16:58
 */
public class ThreeTuple<A, B, C> {

    private A first;

    private B second;

    private C third;

    public ThreeTuple() {
    }

    public ThreeTuple(A first, B second, C third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <A, B, C> ThreeTuple<A, B, C> of(A first, B second, C third) {
        return new ThreeTuple<>(first, second, third);
    }

    @Override
    public String toString() {
        return "ThreeTuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }

    public A getFirst() {
        return first;
    }

    public void setFirst(A first) {
        this.first = first;
    }

    public B getSecond() {
        return second;
    }

    public void setSecond(B second) {
        this.second = second;
    }

    public C getThird() {
        return third;
    }

    public void setThird(C third) {
        this.third = third;
    }
}
