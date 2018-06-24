package avaj_launcher.aircrafts;

import avaj_launcher.towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

    public void updateConditions()
    {
        //todo
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
    }
}