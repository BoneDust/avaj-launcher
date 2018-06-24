package avaj_launcher.weather;

import avaj_launcher.Coordinates;

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
        //todo
        return ("");
    }
}
