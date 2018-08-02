package com.example.tonizinke.performancetestj.sorts;

public class BubbleSort
{
    private long timeDiff;
    public BubbleSort()
    {
        final int[] liste = new ArrayCreator(2000, 1, Integer.MAX_VALUE).getRandomArray();
        final long start = System.currentTimeMillis();
        bubblesort(liste);
        timeDiff = System.currentTimeMillis() - start;
    }

    private void bubblesort(final int[] x)
    {
        boolean unsortiert = true;
        int temp;

        while (unsortiert)
        {
            unsortiert = false;
            for (int i = 0; i < x.length - 1; i++)
                if (x[i] > x[i + 1])
                {
                    temp = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = temp;
                    unsortiert = true;
                }
        }
    }

    public long getTimeDiff()
    {
        return timeDiff;
    }
}
