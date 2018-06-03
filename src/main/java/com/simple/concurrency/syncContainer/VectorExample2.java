package com.simple.concurrency.syncContainer;

import com.simple.concurrency.annotation.NotThreadSafe;

import java.util.Vector;

/**
 * Create by S I M P L E on 2018/04/24 15:36:06
 */

@NotThreadSafe
public class VectorExample2 {

    private static Vector<Integer> integerVector = new Vector<>();

    public static void main(String[] args) {
        while (true) {


            for (int i = 0; i < 10; i++) {
                integerVector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    integerVector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < 10; i++) {
                    integerVector.get(i);
                }
            });
            thread1.start();
            thread2.start();
        }
    }
}
