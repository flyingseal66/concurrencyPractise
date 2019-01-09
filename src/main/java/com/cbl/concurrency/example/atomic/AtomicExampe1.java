package com.cbl.concurrency.example.atomic;

import com.cbl.concurrency.annatations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * AtomicInteger
 */
@ThreadSafe
@Slf4j
public class AtomicExampe1 {

    // the number of requests
    public static int clientTotal = 5000;
    //the number of threads
    public static int threadTotal = 50;

    public static AtomicInteger count = new AtomicInteger(0);

    private static void add() {
        count.incrementAndGet();
        // count.getAndIncrement();
    }
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                } catch (Exception e) {
                    log.error("Exception: ", e);
                }
                add();
                semaphore.release();
                countDownLatch.countDown();
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        log.info("count: {}", count.get());
    }
}
