package avaj_launcher.towers;

import avaj_launcher.Coordinates;
import avaj_launcher.weather.WeatherProvider;

public class WeatherTower extends  Tower
{
    public static String getWeather(Coordinates coordinates)
    {
        WeatherProvider provider = WeatherProvider.getProvider();
        return (provider.getCurrentWeather(coordinates));
    }

    private static void changeWeather()
    {
        //todo
    }
}
