package com.example.tonizinke.performancetestj.sorts;

public class Mergesort
{
    int[] liste;
    long timeDiff;

    public Mergesort()
    {
        liste = new ArrayCreator(2000, 1, Integer.MAX_VALUE).getRandomArray();
        long start = System.currentTimeMillis();
        sort(0, liste.length - 1);
        timeDiff = System.currentTimeMillis() - start;
    }

    private int[] sort(final int l, final int r)
    {
        if(l < r)
        {
            final int q = (l + r) / 2;

            sort(l, q);
            sort(q + 1, r);
            merge(l, q, r);
        }
        return liste;
    }

    private void merge(final int l, final int q, final int r)
    {
        final int[] arr = new int[liste.length];
        int i, j;
        for(i = l; i <= q; i++)
            arr[i] = liste[i];
        for(j = q + 1; j <= r; j++)
            arr[r + q + 1 - j] = liste[j];
        i = l;
        j = r;
        for(int k = l; k <= r; k++)
            if(arr[i] <= arr[j])
            {
                liste[k] = arr[i];
                i++;
            }
            else
            {
                liste[k] = arr[j];
                j--;
            }
    }

    public long getTimeDiff()
    {
        return timeDiff;
    }
}
