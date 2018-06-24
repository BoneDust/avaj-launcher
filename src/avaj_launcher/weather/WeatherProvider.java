package avaj_launcher.weather;

import avaj_launcher.aircrafts.Coordinates;

import java.util.Random;

public class WeatherProvider
{

    private static WeatherProvider weatherProvider = null;
    private static String weather[] = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider()
    {
    }

    public static WeatherProvider getProvider()
    {
        if (weatherProvider == null)
            weatherProvider = new WeatherProvider();
        return (weatherProvider);
    }

    public String getCurrentWeather(Coordinates coordinates)
    {
        int total = 0;
        Random random = new Random();
        total += coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude();
        int choice = random.nextInt(total) % 4;
        return (weather[choice]);
    }
}
