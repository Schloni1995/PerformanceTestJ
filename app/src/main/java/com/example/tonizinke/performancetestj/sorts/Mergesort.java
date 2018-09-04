package com.example.tonizinke.performancetestj.sorts;

public class Mergesort
{
    private long timeDiff;

    public Mergesort()
    {
        int[] liste = new ArrayCreator(1, Integer.MAX_VALUE).getRandomArray();
        doWarmUp(liste);
        doTest(liste);
    }

    private void doWarmUp(int[] liste)
    {
        android.util.Log.d("Warmup", "warmUp gestartet");
        for(int j = 0; j < 20; j++)
            testOp(liste);
        android.util.Log.d("Warmup", "warmUp beendet");
    }

    private void doTest(int[] liste)
    {
        long start = System.nanoTime() / 1000;
        liste = testOp(liste);
        timeDiff = System.nanoTime() / 1000 - start;
    }

    private int[] testOp(int[] liste)
    {
        return sort(liste, 0, liste.length - 1);
    }

    private int[] sort(int[] tempList, final int l, final int r)
    {
        if(l < r)
        {
            final int q = (l + r) / 2;
            tempList = sort(tempList, l, q);
            tempList = sort(tempList, q + 1, r);
            tempList = merge(tempList, l, q, r);
        }
        return tempList;
    }

    private int[] merge(int[] tempList, final int l, final int q, final int r)
    {
        final int[] arr = new int[tempList.length];
        int i, j;
        for(i = l; i <= q; i++)
            arr[i] = tempList[i];
        for(j = q + 1; j <= r; j++)
            arr[r + q + 1 - j] = tempList[j];
        i = l;
        j = r;
        for(int k = l; k <= r; k++)
            if(arr[i] <= arr[j])
            {
                tempList[k] = arr[i];
                i++;
            }
            else
            {
                tempList[k] = arr[j];
                j--;
            }
        return tempList;
    }

    public long getTimeDiff()
    {
        return timeDiff;
    }
}
