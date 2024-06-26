package com.codeappeal.performance;

public class ThreadLimits {

    private static int count = 0;

    private static synchronized void incrementThreadCount() {
        count++;
        System.err.println("New thread #" + count);
    }

    private static void beBusy() {
        while (true) {
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.err.println(e);
            }
        }
    }

    public static void main(String[] argv) {
        while (true) {
            new Thread(new Runnable() {
                public void run() {
                    incrementThreadCount();
                    while (true) {
                        beBusy();
                    }
                }
            }).start();
        }
    }

}
