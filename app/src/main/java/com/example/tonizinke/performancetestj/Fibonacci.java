package com.example.tonizinke.performancetestj;

public class Fibonacci
{
    long timeDiff;

    public Fibonacci(int n)
    {
        long start = System.currentTimeMillis();
        for(int i = 1; i <= n; i++)
            fibonacci(i);
        timeDiff = System.currentTimeMillis() - start;

    }

    public long fibonacci(int n)
    {
        if(n <= 1) return n;
        else return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public long getTimeDiff()
    {
        return timeDiff;
    }
}
