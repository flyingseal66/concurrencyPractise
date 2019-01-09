package com.cbl.concurrency.example.singleton;

import com.cbl.concurrency.annatations.NotThreadSafe;
import com.cbl.concurrency.annatations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在第一次装载时进行创建
 * 饿汉模式可能带来资源浪费，懒汉模式可能造成性能问题
 *
 */
@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2() {

    }

    // 单例对象
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态工厂方法
    public static SingletonExample2 getInstance() {
        return instance;
    }


}
