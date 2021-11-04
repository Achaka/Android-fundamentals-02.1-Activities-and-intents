package com.example.android.twoactivities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;
    private int position = 0;
    private final ArrayList<TextView> items = new ArrayList();
    private static final String STRING_ARRAY_KEY = "com.example.android.twoactivities.STRINGS";
    private static final String POSITION_KEY = "com.example.android.twoactivities.Position";

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        ArrayList<String> strings = new ArrayList<>();
        for (TextView item : items) {
            strings.add(item.getText().toString());
        }
        outState.putInt(POSITION_KEY, position);
        outState.putStringArrayList(STRING_ARRAY_KEY, strings);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        ArrayList<String> stringsArray = savedInstanceState.getStringArrayList(STRING_ARRAY_KEY);
        position = savedInstanceState.getInt(POSITION_KEY);
        for (int i = 0; i < stringsArray.size(); i++) {
            items.get(i).setText(stringsArray.get(i));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textItem1 = findViewById(R.id.text_item1);
        TextView textItem2 = findViewById(R.id.text_item2);
        TextView textItem3 = findViewById(R.id.text_item3);
        TextView textItem4 = findViewById(R.id.text_item4);
        TextView textItem5 = findViewById(R.id.text_item5);
        TextView textItem6 = findViewById(R.id.text_item6);
        TextView textItem7 = findViewById(R.id.text_item7);
        TextView textItem8 = findViewById(R.id.text_item8);
        TextView textItem9 = findViewById(R.id.text_item9);
        TextView textItem10 = findViewById(R.id.text_item10);

        items.add(textItem1);
        items.add(textItem2);
        items.add(textItem3);
        items.add(textItem4);
        items.add(textItem5);
        items.add(textItem6);
        items.add(textItem7);
        items.add(textItem8);
        items.add(textItem9);
        items.add(textItem10);
    }

    public void launchSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply =
                        data.getStringExtra(SecondActivity.EXTRA_REPLY);
                if (position < items.size()) {
                    items.get(position).setText(reply);
                    position++;
                }
            }
        }
    }

}