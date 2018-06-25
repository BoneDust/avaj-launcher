package com.avaj_launcher.towers;

import com.avaj_launcher.aircrafts.Coordinates;
import com.avaj_launcher.weather.WeatherProvider;

public class WeatherTower extends  Tower
{
    public String getWeather(Coordinates coordinates)
    {
        WeatherProvider provider = WeatherProvider.getProvider();
        return (provider.getCurrentWeather(coordinates));
    }

    void changeWeather()
    {
        //todo
    }
}
