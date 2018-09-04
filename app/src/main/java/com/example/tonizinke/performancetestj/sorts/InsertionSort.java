package com.example.tonizinke.performancetestj.sorts;
import android.util.Log;
public class InsertionSort
{
    private long timeDiff;
    public InsertionSort()
    {
        final int[] liste = new ArrayCreator(1, Integer.MAX_VALUE).getRandomArray();
        doWarmUp(liste);
        doTest(liste);
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

    private void doWarmUp(int[] liste)
    {
        Log.d("Warmup", "warmUp gestartet");
        for(int j = 0; j < 20; j++)
        {
            testOp(liste);
        }
        Log.d("Warmup", "warmUp beendet");
    }

    private int[] testOp(int[] liste)
    {
        return insertionSort(liste);
    }

    private int[] insertionSort(final int[] sortieren)
    {
        int temp;
        for(int i = 1; i < sortieren.length; i++)
        {
            temp = sortieren[i];
            int j = i;
            while(j > 0 && sortieren[j - 1] > temp)
            {
                sortieren[j] = sortieren[j - 1];
                j--;
            }
            sortieren[j] = temp;
        }
        return sortieren;
    }
    public long getTimeDiff()
    {
        return timeDiff;
    }
}
