package com.example.android.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT_FLAG = "com.example.android.twoactivities.extra.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonOne = findViewById(R.id.button_one);
        Button buttonTwo = findViewById(R.id.button_two);
        Button buttonThree = findViewById(R.id.button_three);
    }

    public void onTextOneClick(View view) {
        launchSecondActivity(TextId.TEXT_ONE);
    }


    public void onTextTwoClick(View view) {
        launchSecondActivity(TextId.TEXT_TWO);
    }


    public void onTextThreeClick(View view) {
        launchSecondActivity(TextId.TEXT_THREE);
    }

    public void launchSecondActivity(TextId textId) {
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(EXTRA_TEXT_FLAG, textId);
        startActivity(intent);
    }
}

enum TextId {
    TEXT_ONE, TEXT_TWO, TEXT_THREE
}