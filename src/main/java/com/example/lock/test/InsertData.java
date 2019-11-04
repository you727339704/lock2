package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/29 9:41
 */
public class InsertData {
    private Object object = new Object();

    public void insert(Thread thread){
        synchronized (object){

        }
    }


    public synchronized void insert1(Thread thread){

    }

    public  void insert2 (Thread thread){

    }
}
