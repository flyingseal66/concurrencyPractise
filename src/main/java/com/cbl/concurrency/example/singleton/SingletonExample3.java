package com.cbl.concurrency.example.singleton;

import com.cbl.concurrency.annatations.NotRecommend;
import com.cbl.concurrency.annatations.ThreadSafe;

/**
 * 懒汉模式-线程安全
 * 单例实例在第一次使用时进行创建
 * 不推荐，因为性能开销，改进见example4
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3() {

    }

    // 单例对象
    private static SingletonExample3 instance = null;

    // 静态工厂方法
    public static synchronized SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }

}
