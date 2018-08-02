package com.example.tonizinke.performancetestj.stringOP;

import android.util.Log;

public class ConcatString
{
    private final int o;
    long start;
    private long conTime;


    public ConcatString(final int o)
    {
        this.o = o;
        doWarmUp();
        doTest();
    }

    private void doWarmUp()
    {
        Log.d("Warmup", "warmUp gestartet");
        for(int j = 0; j < 20; j++)
        {
            testOp();
        }
        Log.d("Warmup", "warmUp beendet");
    }

    private void testOp()
    {
        String s = "";
        for(int i = 0; i < o; i++)
        {
            s += i;
        }
    }

    private void doTest()
    {
        start = System.currentTimeMillis();
        testOp();
        conTime = System.currentTimeMillis() - start;
    }

    /**
     * @return the conTime
     */
    public long getConTime()
    {
        return conTime;
    }
}