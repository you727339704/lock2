package com.example.lock.test;

/**
 * @author baimugudu
 * @email 2415621370@qq.com
 * @date 2019/10/26 9:53
 */
public class TestTestSleep {
    public static void main(String[] args){
        TestSleep testSleep =  new TestSleep();
        testSleep.start();

        TestSleep testSleep1 =  new TestSleep();
        testSleep1.start();


    }
}
