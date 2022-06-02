package com.example.fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragmentOne = new FragmentOne();
        Bundle bundle = new Bundle();
        bundle.putInt("BUNDLE_KEY", 10);
        fragmentOne.setArguments(bundle);

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container, fragmentOne);
        fragmentTransaction.commit();

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.container, new FragmentTwo());
                fragmentTransaction.commit();
            }
        });
    }
    @Override
    protected void onStart() {
        Log.d("lifeCycle", "Activty : onStart");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.d("lifeCycle", "Activty : onResume");

        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.d("lifeCycle", "Activty : onPause");

        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d("lifeCycle", "Activty : onDestroy");

        super.onDestroy();
    }

}