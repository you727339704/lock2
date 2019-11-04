package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/25 14:59
 */
public class TestMyThread {
    public static void main(String[] args){

        System.out.println("MAIN,ID"+Thread.currentThread().getId()
        );
        MyThread myThread =  new MyThread("thred1");
        myThread.start();

        MyThread myThread2 =  new MyThread("thred2");
        myThread2.run();

    }
}
