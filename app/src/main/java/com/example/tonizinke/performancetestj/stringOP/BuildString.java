package com.example.tonizinke.performancetestj.stringOP;

public class BuildString
{
    private final int o;
    private long start;
    private long sbTime;
    private StringBuilder sb = new StringBuilder();

    public BuildString(final int o)
    {
        this.o = o;
        doWarmUp();
        doTest();
    }

    private void doWarmUp()
    {
        android.util.Log.d("Warmup", "warmUp gestartet");
        for(int j = 0; j < 20; j++)
        {
            testOp();
        }
        android.util.Log.d("Warmup", "warmUp beendet");
    }

    private void doTest()
    {
        start = System.currentTimeMillis();
        sb = new StringBuilder();
        testOp();
        sbTime = System.currentTimeMillis() - start;
    }

    private void testOp()
    {
        for(int i = 0; i < o; i++)
            sb.append(i);
        String s = sb.toString();
    }

    public long getSbTime()
    {
        return sbTime;
    }

}