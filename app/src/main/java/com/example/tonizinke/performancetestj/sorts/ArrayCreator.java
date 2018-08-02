package com.example.tonizinke.performancetestj.sorts;

public class ArrayCreator
{
    private int[] randomArray;

    public ArrayCreator(final int length, final int min, final int max)
    {
        randomArray = new int[length];
        for(int i = 0; i < randomArray.length; i++)
            randomArray[i] = (int) (Math.random() * max) + min;
    }

    public int[] getRandomArray()
    {
        return randomArray;
    }

}
