package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/25 15:07
 */
public class TestMyRunnable {
    public static void main(String[] args){
      System.out.println("主线程ID，"+Thread.currentThread().getId());
        MyRunnable myRunnable = new  MyRunnable();
       // myRunnable.run();
        Thread thread =   new Thread(myRunnable);
        thread.start();
    }
}
