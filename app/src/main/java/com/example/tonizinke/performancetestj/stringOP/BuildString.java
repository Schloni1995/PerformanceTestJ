package com.example.tonizinke.performancetestj.stringOP;

public class BuildString implements Runnable
{
    private final int o;
    long start;
    private long sbTime;

    public BuildString(final int o)
    {
        this.o = o;
    }

    @Override
    public void run()
    {
        start = System.currentTimeMillis();
//        start = System.nanoTime();
        final StringBuilder sb = new StringBuilder();
        for(int i = 0; i < o; i++)
            sb.append(i);
        // System.out.println(sb.toString());
//        sbTime = System.nanoTime() - start;
       String s = sb.toString();
        sbTime = System.currentTimeMillis() - start;
    }

    /**
     * @return the sbTime
     */
    public long getSbTime()
    {
        return sbTime;
    }

}