package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int REQUEST_CODE = 1000;
    ImageView imageView;
    TextView textView;

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @SuppressLint("WrongViewCast")
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

        /**
         * LaunchMode and Intend Flag
         * Intent comingIntent = getIntent();
         *         boolean again = comingIntent.getBooleanExtra("again", true);
         *
         *         if (again == true) {
         *             Intent intent = new Intent(this, secondActivity.class);
         *             startActivity(intent);
         *         }
         */

        /**
         * Thread
         //방법1 - 인스턴스화 해서 계속 변수를 사용하고 싶을 때
         Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
        };
         Thread thread = new Thread(runnable);

         //방법2 - 방법1이 필요 없을 때
         new Thread(new Runnable() {
        @Override
        public void run() {
        //Log.d("runnable", "1");
        //Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_LONG).show();

        }
        }).start();

         //방법2 - 방법1이 필요 없을 때
         new Thread(new Runnable() {
        @Override
        public void run() {
        //Log.d("runnable", "1");
        //Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_LONG).show();

        }
        }).start();

         //UI Thread 만드는 방법
         runOnUiThread(new Runnable() {
        @Override
        public void run() {
        Toast.makeText(MainActivity.this, "toast", Toast.LENGTH_LONG).show();
        }
        });

         */

        /**
         * Context
         Context context = this; //Activity context
         Context mainContext = MainActivity.this;

         Context applicationContext = getApplicationContext(); //application context

         //xml의 뷰 텀포넌트를 자바로 가져오는 방법
         imageView = findViewById(R.id.imageView);
         textView = findViewById(R.id.imageView);

         //xml의 뷰 컴포넌트를 동적으로 변경하는 방법
         imageView.setImageResource(R.drawable.ic_launcher_background);
         textView.setText("test TextView");

         //Res에 정의된 resources를 가져오는 방법
         getApplicationContext().getResources().getString(R.string.~~);
         textView.setText(content);
         */

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