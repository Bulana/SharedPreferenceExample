package com.bulana.sharedpreferenceexample;

import android.content.SharedPreferences;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Toolbar mToolbar;
    Button mRedColor;
    Button mGreenColor;
    Button mYellowColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mRedColor = (Button) findViewById(R.id.red_button);
        mGreenColor = (Button) findViewById(R.id.green_button);
        mYellowColor = (Button) findViewById(R.id.yellow_button);

        if(getColor() != getResources().getColor(R.color.colorPrimaryDark)){
            mToolbar.setBackgroundColor(getColor());
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(getColor());
            }
        }

        mRedColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.red));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.red));
                }
                storeColor(getResources().getColor(R.color.red));
            }
        });

        mGreenColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.green));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.green));
                }
                storeColor(getResources().getColor(R.color.green));
            }
        });

        mYellowColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mToolbar.setBackgroundColor(getResources().getColor(R.color.yellow));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().setStatusBarColor(getResources().getColor(R.color.yellow));
                }
                storeColor(getResources().getColor(R.color.yellow));
            }
        });
    }

    private void storeColor(int color) {
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        mEditor.putInt("color", color);
        mEditor.apply();
    }

    private int getColor() {
        SharedPreferences mSharedPreferences = getSharedPreferences("ToolbarColor", MODE_PRIVATE);
        SharedPreferences.Editor mEditor = mSharedPreferences.edit();
        int selectedColor = mSharedPreferences.getInt("color",getResources().getColor(R.color.colorPrimary));
        return selectedColor;
    }

}
