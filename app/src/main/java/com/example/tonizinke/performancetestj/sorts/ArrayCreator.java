package com.example.tonizinke.performancetestj.sorts;

public class ArrayCreator
{
    private int[] randomArray = new int[5000];
    ArrayCreator(final int min, final int max)
    {
        for(int i = 0; i < randomArray.length; i++)
            randomArray[i] = (int) (Math.random() * max) + min;
    }
    public int[] getRandomArray()
    {
        return randomArray;
    }
}
