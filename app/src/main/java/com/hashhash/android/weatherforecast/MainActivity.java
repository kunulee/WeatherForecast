package com.hashhash.android.weatherforecast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_get_weather;
    EditText edit_lat;
    EditText edit_long;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_get_weather = (Button)findViewById(R.id.btn_get_weather);
        edit_lat = (EditText)findViewById(R.id.edit_lat);
        edit_long = (EditText)findViewById(R.id.edit_long);
        btn_get_weather.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        OpenWeatherAsyncTask task = new OpenWeatherAsyncTask();
        Weather w = null;
        String lati = edit_lat.getText().toString();
        String longi = edit_long.getText().toString();
        int ilati = Integer.parseInt(lati);
        int ilongi = Integer.parseInt(longi);
        try {
            w = task.execute(ilati, ilongi).get();
        } catch (ExecutionException e) {

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
