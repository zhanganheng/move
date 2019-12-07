package com.bw.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ThreeActivity", "onCreate: ");
        setContentView(R.layout.activity_three);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ThreeActivity", "onStart: ");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("ThreeActivity", "onRestart: ");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ThreeActivity", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ThreeActivity", "onPause: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ThreeActivity", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ThreeActivity", "onDestroy: ");
    }
}
