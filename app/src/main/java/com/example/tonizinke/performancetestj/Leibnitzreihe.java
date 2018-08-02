package com.example.tonizinke.performancetestj;

class Leibnitzreihe
{
    long start, end;

    Leibnitzreihe()
    {
        doWarmup();
        doTest();
    }

    private void doTest()
    {
        start = System.currentTimeMillis();
        leibnitz1();
        end = System.currentTimeMillis();
    }

    private void doWarmup()
    {
        for(int i = 0; i < 20; i++)
        {
            leibnitz1();
        }
    }

    private static void leibnitz1()
    {
        double zahl = 0;
        double x = 1;
        boolean b = false;

        int i = 1;
        long loopMax = 10000000;
        while(i <= loopMax)
        {
            if(!b)
            {
                zahl =+ (1 / x);
                b = true;
            }
            else
            {
                zahl =- (1 / x);
                b = false;
            }
            i++;
            x = x + 2;
        }
        System.out.println("Pi ist ungefaehr " + (4.0 * zahl));
    }

    public long getTimeDiff()
    {
        return end - start;
    }

}
