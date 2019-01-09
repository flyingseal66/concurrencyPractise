package com.cbl.concurrency.example.atomic;

import com.cbl.concurrency.annatations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * AtomicReference
 */
@ThreadSafe
@Slf4j
public class AtomicExampe5 {
    private static AtomicIntegerFieldUpdater<AtomicExampe5> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicExampe5.class, "count");

    @Getter
    public volatile int count = 100;

    private static AtomicExampe5 exampe5 = new AtomicExampe5();

    public static void main(String[] args) {
        if (updater.compareAndSet(exampe5, 100, 120)) {
            log.info("update success 1, {}", exampe5.getCount());
        }
        if (updater.compareAndSet(exampe5, 100, 120)) {
            log.info("update success 2, {}", exampe5.getCount());
        } else {
            log.info("update failed 2, {}", exampe5.getCount());
        }
    }
}
