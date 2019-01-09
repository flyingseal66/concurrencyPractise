package com.cbl.concurrency.example.singleton;

import com.cbl.concurrency.annatations.ThreadSafe;

/**
 * 懒汉模式-双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 * 用volatile限制指令重排
 */
@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数
    private SingletonExample5() {

    }

    // 1、 memory = allocate() 分配对象内存空间
    // 2、 ctorInstance() 初始化对象
    // 3. instance = memory 设置instance指向分配的内存

    // 单例对象 volatile + 双重检测 -》 禁止指令重排
    private volatile static SingletonExample5 instance = null;

    // 静态工厂方法
    public static SingletonExample5 getInstance() {
        if (instance == null) { // 双重检测机制  //B
            synchronized (SingletonExample5.class) {
                if (instance == null) {
                    instance = new SingletonExample5(); // A - 3
                }
            }
        }
        return instance;
    }
}