package com.example.android.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        TextId textId;
        if (intent.getSerializableExtra(MainActivity.EXTRA_TEXT_FLAG) instanceof TextId) {
            textId = (TextId) intent.getSerializableExtra(MainActivity.EXTRA_TEXT_FLAG);
        } else textId = null;

        TextView textView = findViewById(R.id.scrolling_text);
        if (textId != null)
            switch (textId) {
                case TEXT_ONE: {
                    textView.setText(getString(R.string.text_one));
                    break;
                }
                case TEXT_TWO: {
                    textView.setText(getString(R.string.text_two));
                    break;
                }
                case TEXT_THREE: {
                    textView.setText(getString(R.string.text_three));
                    break;
                }
                default: {
                    textView.setText(getString(R.string.text_error));
                }
            }
    }
}