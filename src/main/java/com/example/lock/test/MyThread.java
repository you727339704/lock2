package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/25 14:57
 */
public class MyThread extends  Thread {

    public String name;
    public  MyThread(String name){
        this.name = name;
    }

    public void run(){
        System.out.println(name+","+"子线程ID"+Thread.currentThread().getId());
    }
}
