package com.example.addview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> strings;
    LayoutInflater layoutInflater;
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strings = new ArrayList<>();
        strings.add("a");
        strings.add("b");
        strings.add("c");
        strings.add("d");
        strings.add("e");
        strings.add("f");
        strings.add("g");
        strings.add("h");
        strings.add("i");

        container = findViewById(R.id.container);

        layoutInflater = LayoutInflater.from(MainActivity.this);

        for (int i = 0; i < strings.size(); i++) {
            View view = layoutInflater.inflate(R.layout.list_item_view, null, false);
            TextView itemText = view.findViewById(R.id.item_view_text);
            itemText.setText(strings.get(i));

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Log.d("test", "CLICK");
                }
            });

            container.addView(view);
        }
    }
}