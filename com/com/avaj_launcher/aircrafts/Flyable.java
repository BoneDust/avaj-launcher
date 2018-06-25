package com.avaj_launcher.aircrafts;

import com.avaj_launcher.WeatherTower;

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
