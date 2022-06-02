package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String sharedPreferenceName = "SAVE_1";
        String sharedPreferenceKey = "KEY";

        // SharedPreference 에 데이터 저장하는 방법
        SharedPreferences sharedPreferences = getSharedPreferences(sharedPreferenceName,
                MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(sharedPreferenceKey, "hello");
        editor.putString("sharedPreferenceKey2", "bye");
        editor.commit();

        // SharedPreference 의 데이터 삭제 하는 방법
        editor.remove(sharedPreferenceKey);
        editor.clear();
        editor.commit();

        // SharedPreference 에 데이터 불러오는 방법
        String value = sharedPreferences.getString(sharedPreferenceKey, "error");
//        String value = sharedPreferences.getString("avb", "error"); 실패
        Log.d("test1", " value : " + value);

        Person person = new Person("lee", 20);
        Gson gson = new Gson();
        String personJson = gson.toJson(person);
        Log.d("test1", " value : " + personJson);

        String sharedPreferencesPersonKey = "person_key";
        editor.putString(sharedPreferencesPersonKey, personJson);
        editor.commit();

        String personString = sharedPreferences.getString(sharedPreferencesPersonKey, "error 2");
        Person loadedPerson = gson.fromJson(personString, Person.class);

        Log.d("test1", "person age : " + loadedPerson.age);



    }
}