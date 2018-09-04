package com.example.tonizinke.performancetestj.sorts;

import android.util.Log;

public class BubbleSort
{
    private long timeDiff;

    public BubbleSort()
    {
        final int[] liste = new ArrayCreator(1, Integer.MAX_VALUE).getRandomArray();
        doWarmUp(liste);
        doTest(liste);
    }

    private void doWarmUp(int[] liste)
    {
        Log.d("Warmup", "warmUp gestartet");
        for(int j = 0; j < 20; j++)
        {
            testOp(liste);
        }
        Log.d("Warmup", "warmUp beendet");
    }

    private void doTest(int[] liste)
    {
        long start = System.nanoTime() / 1000;
        liste = testOp(liste);
        timeDiff = System.nanoTime() / 1000 - start;
        for(int aListe : liste)
        {
            Log.i("Array", aListe + "");
        }

    }

    private int[] testOp(int[] liste)
    {
        return bubblesort(liste);
    }

    private int[] bubblesort(final int[] x)
    {
        boolean unsortiert = true;
        int temp;

        while(unsortiert)
        {
            unsortiert = false;
            for(int i = 0; i < x.length - 1; i++)
                if(x[i] > x[i + 1])
                {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    unsortiert = true;
                }
        }
        return x;
    }

    public long getTimeDiff()
    {
        return timeDiff;
    }
}
