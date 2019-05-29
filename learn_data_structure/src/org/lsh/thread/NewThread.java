package org.lsh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * 实现的多线程的几种方式
 */
public class NewThread {
    /**
     * 继承Thread类
     */
    public static class UseThread extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println(Thread.currentThread().getName()+" am extends Thread!");
        }
    }

    /**
     * 实现Runnable接口
     */
    public static class UseRunnale implements Runnable{
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+" implement Runnable!");
        }
    }

    /**
     * 实现Callable接口
     */
    public static class UseCallable implements Callable<String>{
        @Override
        public String call() throws Exception {
            System.out.println(Thread.currentThread().getName()+" implement Callable!");
            return "Callable";
        }
    }
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        UseThread useThread =new UseThread();
        useThread.start();

        new Thread(new UseRunnale()).start();

        UseCallable useCallable =new UseCallable();
        FutureTask<String> futureTask=new FutureTask<>(useCallable);
        new Thread(futureTask).start();
        System.out.println("Get useCallable result :"+futureTask.get());
    }
}
