package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/26 9:46
 */
public class TestSleep extends Thread {

    private int i=10;

    //对象锁
    private Object object = new Object();

    @Override
    public  void run(){

        synchronized (object){
            i++;
            System.out.println("i:"+i);
            try {
                System.out.println("线程："+Thread.currentThread().getName()+",进入睡眠状态");
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("线程："+Thread.currentThread().getName()+",睡眠结束");
            i++;
            System.out.println("i:"+i);

        }

    }
}
