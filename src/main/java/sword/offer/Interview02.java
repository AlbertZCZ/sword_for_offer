package sword.offer;

/**
 * Create by zhang on 2018/3/24
 */
public class Interview02 {
    /**
     * 懒汉式，线程安全
     */
    public static class Singleton01 {
        private Singleton01() {
        }
        private final static Singleton01 SINGLETON_01 = new Singleton01();
        public static Singleton01 getInstance() {
            return SINGLETON_01;
        }
    }

    /**
     * 饿汉式，线程不安全
     */
    public static class Singleton02 {
        private Singleton02(){}
        private static Singleton02 singleton02;
        public static Singleton02 getInstance() {
            if (singleton02 == null) {
                singleton02 = new Singleton02();
            }
            return singleton02;
        }
    }

    /**
     * 饿汉式，线程安全，多线程下效率不高
     */
    public static class Singleton03 {
        private Singleton03() {}
        private static Singleton03 singleton03;
        public synchronized static Singleton03 getInstance() {
            if (singleton03 == null) {
                singleton03 = new Singleton03();
            }
            return singleton03;
        }
    }

    /**
     * 饿汉式，线程安全，变种
     */
    public static class Singleton04 {
        private Singleton04() {}
        private static Singleton04 singleton04;
        static {
            singleton04 = new Singleton04();
        }
        public static Singleton04 getInstance() {
            return singleton04;
        }
    }

    /**
     * 懒汉式，使用静态内部类，线程安全【推荐】
     */
    public static class Singleton05 {
        private Singleton05() {}
        private final static class SingletonHandler {
            private static final Singleton05 SINGLETON_05 = new Singleton05();
        }

        public static Singleton05 getInstance() {
            return SingletonHandler.SINGLETON_05;
        }
    }

    /**
     * 使用双重校验锁，线程安全【推荐】
     */
    public static class Singleton06 {
        private Singleton06() {}
        private static Singleton06 singleton06;
        public static Singleton06 getInstance() {
            if (singleton06 == null) {
                synchronized (Singleton06.class) {
                    if (singleton06 == null) {
                        singleton06 = new Singleton06();
                    }
                }
            }
            return singleton06;
        }
    }
}
