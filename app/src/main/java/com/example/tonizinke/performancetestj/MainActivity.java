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

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
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

        ackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Ackermann.ackITT(0, 0);
                Log.i(MainActivity.class.getSimpleName(), "Finished");
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        });
        cpuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new CPUeater(2);
                } catch (InterruptedException e) {
                    Log.e("ERROR", e.getMessage());
                }
                Log.i(MainActivity.class.getSimpleName(), "Finished");
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        });
        eratoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Eratosthenes();
                Log.i(MainActivity.class.getSimpleName(), "Finished");
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        });
        leibnitzButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Leibnitzreihe();
                Log.i(MainActivity.class.getSimpleName(), "Finished");
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        });
        millerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new MillerRabin();
                Log.i(MainActivity.class.getSimpleName(), "Finished");
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        });
        buildButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final BuildString bs = new BuildString(100000);
                final Thread build = new Thread(bs);
                build.start();
                Log.i(MainActivity.class.getSimpleName(), "Finished");
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        });
        concatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ConcatString cs = new ConcatString(100000);
                final Thread concat = new Thread(cs);
                concat.start();

                Log.i(MainActivity.class.getSimpleName(), "Finished");
                Toast.makeText(MainActivity.this, "Finished", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
