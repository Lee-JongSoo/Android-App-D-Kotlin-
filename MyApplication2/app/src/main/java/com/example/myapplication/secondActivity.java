package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class secondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifeCycle", "2: onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        /**
         Intent intent = getIntent();
         int data = intent.getIntExtra("intent_key", 0);
         String stringData = intent.getStringExtra("intent_key_string");
         Log.d("intent_key", "" + data);
         Log.d("intent_key", "" + stringData);
         */

        /**
         * 작업을 마친 후
         Intent intent = new Intent();
         intent.putExtra("result", "성공");
         setResult(300, intent);
         finish();
         */

        /**
         * LaunchMode and Intend Flag
         Intent intent = new Intent(this, ThirdActivity.class);
         startActivity(intent);
         */
    }

    @Override
    protected void onStart() {
        Log.d("lifeCycle", "2: onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifeCycle", "2: onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("lifeCycle", "2: onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("lifeCycle", "2: onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifeCycle", "2: onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("lifeCycle", "2: onRestart");
        super.onRestart();
    }
}