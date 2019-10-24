package com.hashhash.android.weatherforecast;

import android.os.AsyncTask;

public class OpenWeatherAsyncTask extends AsyncTask<Integer, Void, Weather>
{
    @Override
    protected Weather doInBackground(Integer... params) {
        OpenWeatherClient client = new OpenWeatherClient();
        int lati = params[0];
        int longi = params[1];
        Weather w = client.getWeather(lati, longi);
        return w;
    }
}
