package com.example.tonizinke.performancetestj.sorts;

public class InsectionSort
{
	private long timeDiff;

	public InsectionSort()
	{
		final int[] liste = new ArrayCreator(2000, 1, Integer.MAX_VALUE).getRandomArray();
		final long start = System.currentTimeMillis();
		insertionSort(liste);
		timeDiff = System.currentTimeMillis() - start;
	}

	private int[] insertionSort(final int[] sortieren)
	{
		int temp;
		for (int i = 1; i < sortieren.length; i++)
		{
			temp = sortieren[i];
			int j = i;
			while (j > 0 && sortieren[j - 1] > temp)
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
