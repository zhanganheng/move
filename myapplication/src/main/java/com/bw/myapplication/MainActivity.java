package com.bw.myapplication;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button but;
    private List<Fragment> list;

    private Button but1;
    private Button but2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("MainActivity", "onCreate: ");
        but = (Button) findViewById(R.id.but);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ThreeActivity.class);
               startActivity(intent);
               finish();
            }
        });
        but1 = (Button) findViewById(R.id.but1);
        but2 = (Button) findViewById(R.id.but2);

        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment,new OneFragment())
                        .commit();
            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment,new TwoFragment())
                        .commit();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("MainActivity", "onStart: ");

    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("MainActivity", "onRestart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("MainActivity", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("MainActivity", "onPause: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("MainActivity", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("MainActivity", "onDestroy: ");
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        Log.i("MainActivity", "onWindowFocusChanged: ");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("MainActivity", "onSaveInstanceState: ");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.i("MainActivity", "onConfigurationChanged: ");
    }
}
