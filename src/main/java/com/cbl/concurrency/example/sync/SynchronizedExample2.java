package com.cbl.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * modify a class and a static method
 */
@Slf4j
public class SynchronizedExample2 {
    private int count = 0;

    // modify a class
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) {
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }


        //}
    }
    // Code block
    public static synchronized void test2(int j) {
        for (int i = 0; i < 10; i++) {
            log.info("test2 {} - {}", j, i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            example1.test2(1);
        });
        service.execute(() -> {
            example2.test2(2);
        });
    }
}
