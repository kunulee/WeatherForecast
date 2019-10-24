package com.hashhash.android.weatherforecast;

public class Weather {
    int lat;
    int longi;
    int temperature;
    int cloudy;
    String city;

    public void setLat(int lat){ this.lat = lat;}
    public void setIon(int longi){ this.longi = longi;}
    public void setTemprature(int t){ this.temperature = t;}
    public void setCloudy(int cloudy){ this.cloudy = cloudy;}
    public void setCity(String city){ this.city = city;}

    public int getLat(){ return lat;}
    public int getIon() { return longi;}
    public int getTemprature() { return temperature;}
    public int getCloudy() { return cloudy; }
    public String getCity() { return city; }
}
