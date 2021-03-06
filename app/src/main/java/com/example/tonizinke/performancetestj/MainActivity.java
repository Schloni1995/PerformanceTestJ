package com.example.tonizinke.performancetestj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tonizinke.performancetestj.maths.Fibonacci;
import com.example.tonizinke.performancetestj.maths.Leibnitzreihe;
import com.example.tonizinke.performancetestj.prime.Eratosthenes;
import com.example.tonizinke.performancetestj.sorts.BubbleSort;
import com.example.tonizinke.performancetestj.sorts.InsertionSort;
import com.example.tonizinke.performancetestj.sorts.Mergesort;
import com.example.tonizinke.performancetestj.stringOP.BuildString;
import com.example.tonizinke.performancetestj.stringOP.ConcatString;

public class MainActivity extends AppCompatActivity
{
    long start = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fibButton = findViewById(R.id.btn_fibonacci);
        Button eratoButton = findViewById(R.id.btn_eratosthenes);
        Button leibnitzButton = findViewById(R.id.btn_leipnitz);
        Button concatButton = findViewById(R.id.btn_concat);
        Button buildButton = findViewById(R.id.btn_build);
        Button bubbleButton = findViewById(R.id.btn_bubblesort);
        Button insButton = findViewById(R.id.btn_insertionsort);
        Button merButton = findViewById(R.id.btn_mergesort);

        fibButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Fibonacci fib = new Fibonacci(40);
                toOutput(String.valueOf(fib.getTimeDiff()));
            }
        });
        eratoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Eratosthenes er = new Eratosthenes(7000);
                toOutput(String.valueOf(er.getTimeDiff()));
            }
        });
        leibnitzButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Leibnitzreihe lr = new Leibnitzreihe();
                toOutput(String.valueOf(lr.getTimeDiff()));
            }
        });
        buildButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final BuildString bs = new BuildString(50000);
                toOutput(String.valueOf(bs.getSbTime()));
            }
        });
        concatButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final ConcatString cs = new ConcatString(10000);
                toOutput(String.valueOf(cs.getConTime()));
            }
        });
        bubbleButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                BubbleSort bs = new BubbleSort();
                toOutput(String.valueOf(bs.getTimeDiff()));
            }
        });
        insButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                InsertionSort is = new InsertionSort();
                toOutput(String.valueOf(is.getTimeDiff()));
            }
        });
        merButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Mergesort ms = new Mergesort();
                toOutput(String.valueOf(ms.getTimeDiff()));
            }
        });

        Toast.makeText(MainActivity.this, (System.currentTimeMillis() - start) + "", Toast.LENGTH_LONG).show();
    }

    public void toOutput(String msg)
    {
        Log.i(MainActivity.class.getSimpleName(), msg);
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}
