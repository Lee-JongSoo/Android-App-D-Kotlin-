package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1000;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("lifeCycle", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         *  명시적 Intent
         Intent intent = new Intent(this, secondActivity.class);
         intent.putExtra("intent_key", 5);
         intent.putExtra("intent_key_string", "string");
         startActivity(intent);
         */

        /**
         * 암시적 Intent
         Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https:google.com"));
         startActivity(intent);
         */

        /**
         * REQUEST_CODE
         Intent intent = new Intent(this, secondActivity.class);
         intent.putExtra("intent_key", 5);
         intent.putExtra("intent_key_string", "string");
         startActivityForResult(intent, REQUEST_CODE);

         @Override
         protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
         if (requestCode == REQUEST_CODE) {
         if (resultCode == 200) {
         String result = data.getStringExtra("result");
         Log.d("onActivityResult", "result : " + result);
         } else if (resultCode == 300) {
         Log.d("onActivityResult", "실패");
         }
         }
         }
         */

        Intent comingIntent = getIntent();
        boolean again = comingIntent.getBooleanExtra("again", true);

        if (again == true) {
            Intent intent = new Intent(this, secondActivity.class);
            startActivity(intent);
        }

    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.d("lifeCycle", "1: onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifeCycle", "1: onResume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("lifeCycle", "1: onPause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.d("lifeCycle", "1: onStop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifeCycle", "1: onDestroy");
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        Log.d("lifeCycle", "1: onRestart");
        super.onRestart();
    }
}