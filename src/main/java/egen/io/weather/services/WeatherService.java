package egen.io.weather.services;

import java.util.List;

import egen.io.weather.details.Weather;

public interface WeatherService {
	public void createWeather(Weather weather);
	public String findCityWeather(String city, String property);
	public List<Weather> findallcities();
	public String findbyproperty(String city,String duration, String property);

}
