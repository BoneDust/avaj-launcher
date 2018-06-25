package com.avaj_launcher.aircrafts;

import com.avaj_launcher.towers.WeatherTower;


import java.util.HashMap;
import java.util.Map;

public class JetPlane extends Aircraft implements Flyable
{
    private WeatherTower weatherTower;
    private Map<String, String> dictionary = new HashMap<String, String>();
    {
        dictionary.put("SUN", "It's getting hot in here.");
        dictionary.put("RAIN", "Just hope this rain doesn't turn into a storm.");
        dictionary.put("FOG", "Meh ... its just some fog.");
        dictionary.put("SNOW", "Hurray for the snow! I'll soon be landing.");
    }

    JetPlane(String name, Coordinates coordinates)
    {
        super(name,coordinates);
    }

    public void updateConditions()
    {
        int x, y, z;
        String weather = weatherTower.getWeather(coordinates);
        switch (weather)
        {
            case "SUN":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude() + 10;
                z = (coordinates.getHeight() + 2 >= 100) ? 100 : coordinates.getHeight() + 2;
                coordinates = new Coordinates(x, y, z);
                System.out.println("JetPlane " + getName() + "(" + getId() + "): " + dictionary.get("SUN"));
                break;
            case "RAIN":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude() + 5;
                z = coordinates.getHeight();
                coordinates = new Coordinates(x, y, z);
                System.out.println("JetPlane " + getName() + "(" + getId() + "): " + dictionary.get("RAIN"));
                break;
            case "FOG":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude() + 1;
                z = coordinates.getHeight();
                coordinates = new Coordinates(x, y, z);
                System.out.println("JetPlane " + getName() + "(" + getId() + "): " + dictionary.get("FOG"));
                break;
            case "SNOW":
                x = coordinates.getLongitude();
                y = coordinates.getLatitude();
                z = (coordinates.getHeight()  - 7 <= 0) ? 0 : coordinates.getHeight() - 7;
                coordinates = new Coordinates(x, y, z);
                if (coordinates.getHeight() == 0)
                {
                    System.out.println("JetPlane " + getName() + "(" + getId() + "): Landing");
                    weatherTower.unregister(this);
                }
                else
                    System.out.println("JetPlane " + getName() + "(" + getId() + "): " + dictionary.get("SNOW"));
                break;
        }
    }

    public void registerTower(WeatherTower weatherTower)
    {
        this.weatherTower = weatherTower;
        this.weatherTower.register(this);
    }
}