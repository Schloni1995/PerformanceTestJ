package com.example.tonizinke.performancetestj;

class Leibnitzreihe
{
    private final static double MILLI = Math.pow(10, -3);
    private static long loopMax = 10000000;
    long start, end;

    Leibnitzreihe()
    {
//        System.out.println("Die Leibnizsche Zahlenreihe");
        start = System.currentTimeMillis();
        leibnitz1();
        end = System.currentTimeMillis();

//        start = System.currentTimeMillis();
//        leibnitz2();
//        end = System.currentTimeMillis();
    }

    private static void leibnitz1()
    {
        double zahl = 0;
        double x = 1;
        boolean b = false;

        int i = 1;
        while(i <= loopMax)
        {
            if(!b)
            {
                zahl = zahl + (1 / x);
                b = true;
                // System.out.println("zahl + (1/" + x + ")" + " PI=zahl*4 == "
                // + zahl * 4);
            }
            else
            {
                zahl = zahl - (1 / x);
                b = false;
                // System.out.println("zahl - (1/" + x + ")" + " PI=zahl*4 == "
                // + zahl * 4);
            }
            i++;
            x = x + 2;
        }
        System.out.println("Pi ist ungefaehr " + (4.0 * zahl));
    }

    private static void leibnitz2()
    {
        /*
         * Die unendliche (Leibnitz-)Reihe 1 - 1/3 + 1/5 - 1/7 + 1/9 - ... hat
         * den Wert Pi/4. Schreiben Sie ein Programm, das f�r ein festes n mit
         * Hilfe der Formel einen N�herungswert f�r Pi berechnet.
         */

        // uebrigens: der Mann hiess Leibniz und nicht, wie der Keks, Leibnitz

        final long n = loopMax;
        double pi4tel = 0.0;

        // fuer jedes i von 1 bis n bilde 1.0 / (2 * i - 1) und addiere
        // bzw. subtrahiere, je nachdem ob i ungerade oder gerade ist
        for(int i = 1; i <= n; ++i)
            if(i % 2 == 1) pi4tel += 1.0 / (2 * i - 1);
            else pi4tel -= 1.0 / (2 * i - 1);

        // die Reihe ergibt Pi/4 nicht Pi!
//        System.out.println("Pi ist ungefaehr " + (4.0 * pi4tel));
    }

    public long getTimeDiff()
    {
        return end - start;
    }

}
