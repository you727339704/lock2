//package com.example.lock.test;
//
//import java.util.ArrayList;
//
///**
// * @author baimugudu
// * @email 2415621370@qq.com
// * @date 2019/10/26 9:59
// */
//public class Test {
//
//    public static void main(String[] args)  {
//        final InsertData insertData = new InsertData();
//
//        new Thread() {
//            public void run() {
//                insertData.insert(Thread.currentThread());
//            };
//        }.start();
//
//
//        new Thread() {
//            public void run() {
//                insertData.insert(Thread.currentThread());
//            };
//        }.start();
//
//        new Thread() {
//            public void run() {
//                insertData.insert(Thread.currentThread());
//            };
//        }.start();
//    }
//}
//
//class InsertData {
//    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
//    private Object object = new Object();
//
//    public  void insert(Thread thread){
//
//        synchronized(object){
//            for(int i=0;i<5;i++){
//                System.out.println(thread.getName()+"在插入数据"+i);
//                arrayList.add(i);
//            }
//        }
//
//    }
//
//}
//
//
