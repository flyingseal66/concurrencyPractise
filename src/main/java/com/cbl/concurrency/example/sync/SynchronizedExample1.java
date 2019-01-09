package com.cbl.concurrency.example.sync;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * modify code block and method
 */
@Slf4j
public class SynchronizedExample1 {
    private int count = 0;
    // Code block
    public  void test1() {
        synchronized (this) {
            for (int i = 0; i < 100000; i++) {
                System.out.println(++count);
            }
        }


        //}
    }
    // Code block
    public synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            log.info("test2 - {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            example1.test1();
        });
        service.execute(() -> {
            example1.test1();
        });
    }
}
