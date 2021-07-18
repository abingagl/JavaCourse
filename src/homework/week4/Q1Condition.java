//package homework.week4.q1;
//
//import java.util.concurrent.ExecutionException;
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.Lock;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * 本周作业：（必做）思考有多少种方式，在main函数启动一个新线程或线程池，
// * 异步运行一个方法，拿到这个方法的返回值后，退出主线程？
// * 写出你的方法，越多越好，提交到github。
// *
// * 一个简单的代码参考：
// */
//public class Homework1Condition {
//    private volatile Integer value = null;
//    private Lock lock = new ReentrantLock();
//    private Condition calComplete = lock.newCondition();
//
//    public static void main(String[] args) throws InterruptedException, ExecutionException {
//
//        long start=System.currentTimeMillis();
//
//        // 在这里创建一个线程或线程池，
//        // 异步执行 下面方法
//        final Homework1Condition method = new Homework1Condition();
//        Thread thread = new Thread(() -> {
//            method.sum(45);
//        });
//        thread.start();
//
//        int result = method.getValue();
//
//        // 确保  拿到result 并输出
//        System.out.println("异步计算结果为："+result);
//
//        System.out.println("使用时间："+ (System.currentTimeMillis()-start) + " ms");
//
//        // 然后退出main线程
//    }
//
//    private static Integer sum() {
//        lock.lock();
//        try {
//            value = fibo(num);
//            calComplete.signal();
//        } finally {
//            lock.unlock();
//        }
//    }
//
//    private static Integer fibo(int a) {
//        if ( a < 2) {
//            return 1;
//        }
//        return fibo(a-1) + fibo(a-2);
//    }
//
//    @Override
//    public Integer call() throws Exception {
//        return fibo(36);
//    }
//}
