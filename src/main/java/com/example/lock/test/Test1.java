package com.example.lock.test;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/29 10:25
 */
public class Test1 {

    private ArrayList<Integer> arrayList = new ArrayList<>();
    Lock lock = new ReentrantLock();//可重入锁


    public static void main(String[] args){

        Test1 test1 = new Test1();
        new Thread(){
            public void run(){
                test1.insert(Thread.currentThread());
            }
        }.start();

        new Thread(){
            public void run(){
                test1.insert(Thread.currentThread());
            }
        }.start();
    }

    public void insert(Thread thread){

      //  lock.lock();//获取锁

        if(lock.tryLock()){
            try{
                System.out.println(thread.getName()+",得到了锁");
                for (int i = 0; i < 5; i++) {
                    arrayList.add(i);
                }

            }catch (Exception e){
                e.printStackTrace();
            }finally {
                System.out.println(thread.getName()+",释放了锁");
                lock.unlock();
            }

        }else{
            System.out.println(thread.getName()+",获取锁失败");
        }


    }
}
