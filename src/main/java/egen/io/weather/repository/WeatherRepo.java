package egen.io.weather.repository;

import java.util.List;

import egen.io.weather.details.Weather;

public interface WeatherRepo {
	
	public void saveWeather(Weather weather);
	public String findCityWeather(String city, String property);
	public List<Weather> findallcities();
	public String findbyproperty(String city, String duration, String property);


}
