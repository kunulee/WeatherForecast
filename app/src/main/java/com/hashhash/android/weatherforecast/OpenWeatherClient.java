package com.hashhash.android.weatherforecast;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/* 이 클래스는 반드시 Asynchronous 하게 동작해야 된다 */
public class OpenWeatherClient {
    final static String url = "http://api.openweathermap.org/data/2.5/weather";
    final static String api_key = "0d16e04bbfc2cd7f27b775141ba12413";
    final static String TAG = "OpenWeatherClient";
    public Weather getWeather(int lat, int longi) {
        Weather w = new Weather();
        String request_url = url + "?lat=" + lat + "&lon=" + longi + "&appid=" + api_key;

        try {
            URL url = new URL(request_url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(connection.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            StringBuilder sb = new StringBuilder();

            String input_str;
            while ((input_str = br.readLine()) != null) {
                sb.append(input_str);
            }
            JSONObject json = new JSONObject(sb.toString());

            int temperature = json.getJSONObject("main").getInt("temp");
            String name = json.getString("name");
            Log.e(TAG, "name = " + name + ", temp=" + temperature);
            w.setCity(name);
            w.setTemprature(temperature);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return w;
    }
}
