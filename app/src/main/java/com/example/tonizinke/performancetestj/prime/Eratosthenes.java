package com.example.tonizinke.performancetestj.prime;

import android.util.Log;

public class Eratosthenes
{
    private long timeDiff;

    public Eratosthenes(int zahl)
    {
        doWarmUp(zahl);
        doTest(zahl);
    }

    private void doWarmUp(int zahl)
    {
        Log.d("Warmup", "warmUp gestartet");
        for(int i = 0; i < 20; i++)
        {
            testOp(zahl);
        }
        Log.d("Warmup", "warmUp beendet");
    }

    private void testOp(int zahl)
    {
        zahl++;
        aussieben(zahl);
    }

    private void doTest(int zahl)
    {
        long start = System.currentTimeMillis();
        testOp(zahl);
        timeDiff = System.currentTimeMillis() - start;
    }

    public static void aussieben(final int zahl)
    {
        /*Syntax übersetzt aus C#-Code
        Quelle: https://de.wikibooks.org/wiki/Algorithmensammlung:_Zahlentheorie:_Sieb_des_Eratosthenes
         */
        int n = zahl;
        boolean[] prim = new boolean[n];
        for(int i = 2; i < n; i++)
        {
            prim[i] = true;
        }

        int i = 2;
        for(; i * i < n; i++)
        {
            if(prim[i])
            {
                System.out.print(i + " ");
                for(int j = i * i; j < n; j += i)
                {
                    prim[j] = false;
                }
            }
        }
        for(; i < n; i++)
        {
            if(prim[i])
            {
                System.out.print(i + " ");
            }
        }
    }

    public long getTimeDiff()
    {
        return timeDiff;
    }
}