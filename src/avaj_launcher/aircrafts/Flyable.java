package avaj_launcher.aircrafts;

import avaj_launcher.towers.WeatherTower;

public interface Flyable
{
    public void updateConditions();
    public void registerTower(WeatherTower WeatherTower);
}
