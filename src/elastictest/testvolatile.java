package com.hackerrank.elastictest;

public class testvolatile {
    /**
     * What does the main thread print
     * a) always 0
     * b) always 1
     * c) always 2
     * d) sometimes 0, some 1 and some 2
     * e) something else (don't remember the last option
     */

    static volatile int i = 0;

    private static void calculate() throws InterruptedException {
        Thread thread1 = new Thread(() -> i++);
        Thread thread2 = new Thread(() -> i++);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int j = 0; j < 100000; j++) {
            i = 0;
            calculate();
            if(i % 2 != 0){
                return;
            }
        }
    }
}
