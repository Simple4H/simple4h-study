package com.simple.concurrency.syncContainer;

import com.simple.concurrency.annotation.NotThreadSafe;

import java.util.Iterator;
import java.util.Vector;

/**
 * Create by S I M P L E on 2018/04/24 15:36:06
 */

@NotThreadSafe
public class VectorExample3 {

    // java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> vector) {
        for (Integer i : vector) {
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    // java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> vector) {
        Iterator<Integer> iterator = vector.iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            if (i.equals(3)) {
                vector.remove(i);
            }
        }
    }

    private static void test3(Vector<Integer> vector) {
        for (int i = 0; i < vector.size(); i++) {
            if (vector.get(i).equals(3)) {
                vector.remove(i);
            }
        }
    }

    public static void main(String[] args) {

        Vector<Integer> integerVector = new Vector<>();
        integerVector.add(1);
        integerVector.add(2);
        integerVector.add(3);

//        test1(integerVector);
//        test2(integerVector);
        test3(integerVector);
    }
}
