package common;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestRTTLock {

    private double x, y;

    private ReentrantReadWriteLock lock      = new ReentrantReadWriteLock();
    // 读锁
    private Lock                   readLock  = lock.readLock();
    // 写锁
    private Lock                   writeLock = lock.writeLock();

    public static void main(String[] args) {
        TestRTTLock testRTTLock = new TestRTTLock();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                testRTTLock.move(1, 1);
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(testRTTLock.read());
            }
        }).start();

    }

    public void move(double deltaX, double deltaY) {
        // 获取写锁
        writeLock.lock();
        try {
            x += deltaX;
            y += deltaY;
        } finally {
            // 释放写锁
            writeLock.unlock();
        }
    }

    public double read() {
        // 获取读锁
        readLock.lock();
        try {
            return Math.sqrt(x * x + y * y);
        } finally {
            // 释放读锁
            readLock.unlock();
        }
    }
}