package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView number0;
    TextView number1;
    TextView number2;
    TextView number3;
    TextView number4;
    TextView number5;
    TextView number6;
    TextView number7;
    TextView number8;
    TextView number9;

    TextView plus;
    TextView minus;
    TextView equal;
    TextView result;

    Integer first = null;
    Integer second = null;
    String operator;
    String tmp = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupListener();
    }

    private void findViews() {
        number0 = findViewById(R.id.number_0);
        number1 = findViewById(R.id.number_1);
        number2 = findViewById(R.id.number_2);
        number3 = findViewById(R.id.number_3);
        number4 = findViewById(R.id.number_4);
        number5 = findViewById(R.id.number_5);
        number6 = findViewById(R.id.number_6);
        number7 = findViewById(R.id.number_7);
        number8 = findViewById(R.id.number_8);
        number9 = findViewById(R.id.number_9);

        plus = findViewById(R.id.number_plus);
        minus = findViewById(R.id.number_minus);
        equal = findViewById(R.id.number_equal);
        result = findViewById(R.id.number_result);
    }

    private void setupListener() {
        number0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "0";
            }
        });
        number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "1";

            }
        });
        number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "2";

            }
        });
        number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "3";

            }
        });
        number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "4";

            }
        });
        number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "5";

            }
        });
        number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "6";

            }
        });
        number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "7";

            }
        });
        number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "8";

            }
        });
        number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tmp = tmp + "9";

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (operator == "+") {
                    return;
                }
                if (operator == "-") {
                    operator = "+";
                    return;
                }

                operator = "+";
                if (first != null) {
                    second = Integer.parseInt(tmp);
                } else {
                    first = Integer.parseInt(tmp);
                }
                tmp = "";
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (operator == "-") {
                    return;
                }
                if (operator == "+") {
                    operator = "-";
                    return;
                }

                operator = "-";
                if (first != null) {
                    second = Integer.parseInt(tmp);
                } else {
                    first = Integer.parseInt(tmp);
                }
                tmp = "";
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (first != null) {
                    second = Integer.parseInt(tmp);
                } else {
                    first = Integer.parseInt(tmp);
                }
                result.setText(String.valueOf(calculator()));
            }
        });
    }

    private int calculator() {
        int result;
        if (operator == "+") {
            result = first + second;
        } else {
            result = first - second;
        }
        first = result;
        operator = "";
        return result;
    }
}