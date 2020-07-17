package com.xjj;

/**
 * Created by XJJ on 2020/5/11.
 *
 * 使用双重检查锁实现懒汉式线程安全
 */
public class Singleton {
    // volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。
    private volatile static Singleton instance = null;
    // 实现单例模式的关键
    private Singleton() {}

    public static Singleton getInstance() {
        // 先判断是否实例过，没有才能加入加锁代码
        if (instance == null) {
            // 类对象加锁
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        // 返回单例对象
        return instance;
    }
}
