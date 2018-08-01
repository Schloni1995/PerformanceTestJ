package com.example.tonizinke.performancetestj.stringOP;

import android.util.Log;

public class ConcatString implements Runnable
{
    private final int o;
    long start;
    private long conTime;


    public ConcatString(final int o)
    {
        this.o = o;
    }

    @Override
    public void run()
    {

        start = System.currentTimeMillis();
        String s = "";
        for(int i = 0; i < o; i++)
        {
            s += i;
        }
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