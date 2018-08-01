package com.example.tonizinke.performancetestj.stringOP;

public class Test {
    public static final double MILLI = Math.pow(10, -3);
    public int o = 10000;

    public Test() throws InterruptedException {
        final ConcatString cs = new ConcatString(o);
        final BuildString bs = new BuildString(o);
        final Thread concat = new Thread(cs);
        final Thread build = new Thread(bs);
        concat.start();
        build.start();

        // while (!concat.isInterrupted() || !build.isInterrupted())
        // Thread.sleep(1000);
        while (concat.isAlive() || build.isAlive())
            Thread.sleep(1000);

        System.out.println("Concattime = " + cs.getConTime() * MILLI + " s");
        System.out.println("Buildingtime = " + bs.getSbTime() * MILLI + " s");
    }
}
