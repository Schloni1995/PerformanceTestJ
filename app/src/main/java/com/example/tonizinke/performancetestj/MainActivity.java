package com.example.tonizinke.performancetestj;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.tonizinke.performancetestj.cpu.CPUeater;
import com.example.tonizinke.performancetestj.prime.Eratosthenes;
import com.example.tonizinke.performancetestj.prime.MillerRabin;
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

        Button ackButton, cpuButton, leibnitzButton;
        Button eratoButton, millerButton;
        Button concatButton, buildButton;

        ackButton = findViewById(R.id.btn_ackermann);
        cpuButton = findViewById(R.id.btn_cpueater);
        eratoButton = findViewById(R.id.btn_eratosthenes);
        leibnitzButton = findViewById(R.id.btn_leipnitz);
        millerButton = findViewById(R.id.btn_miller_rabin);
        concatButton = findViewById(R.id.btn_concat);
        buildButton = findViewById(R.id.btn_build);

        ackButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Ackermann.ackITT(0, 0);
                toOutput("Finished");
            }
        });
        cpuButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                try
                {
                    new CPUeater(2);
                } catch(InterruptedException e)
                {
                    Log.e("ERROR", e.getMessage());
                }
                toOutput("Finished");
            }
        });
        eratoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                new Eratosthenes();
                toOutput("Finished");
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
        millerButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                new MillerRabin();
                toOutput("Finished");
            }
        });
        buildButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final BuildString bs = new BuildString(50000);
                final Thread build = new Thread(bs);
                build.start();
                while(build.isAlive())
                {

                }
                toOutput(String.valueOf(bs.getSbTime()));
            }
        });
        concatButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final ConcatString cs = new ConcatString(50000);
                final Thread concat = new Thread(cs);
                concat.start();
                while(concat.isAlive())
                {

                }
                toOutput(String.valueOf(cs.getConTime()));
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
