package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/25 14:45
 */
public class A extends Thread {

    private static  int num = 0;
    public A(){
        num++;
    }

    @Override
    public void  run(){
        System.out.println(num);
    }
}
