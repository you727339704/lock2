package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/25 15:06
 */
public class MyRunnable implements Runnable {

    public MyRunnable(){}
    @Override
    public void run() {
        System.out.println("子线程，"+Thread.currentThread().getId());
    }
}
