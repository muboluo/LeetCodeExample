package jv.sword;

/**
 * 剑指offer 01
 * 七种单例模式， 3懒4饿
 * 3懒： 1 基本类型 basic；2 静态内部类 static inner class； 3 枚举 enum
 * 4饿： 1 基本类型 basic；2 同步方法 synchronized method； 3 静态代码块 static code block ； 4 双重锁验证 double block
 * 推荐： 静态内部类 ，枚举，双重锁验证
 * 为什么推荐这三种？
 */
public class Test01 {

    // 懒1
    public static class Singleton1 {

        private static Singleton1 INSTANCE = new Singleton1();

        private Singleton1() {

        }

        public static Singleton1 getINSTANCE() {
            return INSTANCE;
        }

    }

    // 饿1 ,线程不安全
    public static class Singleton2 {

        private static Singleton2 INSTANCE;

        private Singleton2() {

        }

        public static Singleton2 getINSTANCE() {

            if (INSTANCE == null) {
                INSTANCE = new Singleton2();
            }
            return INSTANCE;
        }

    }

}
