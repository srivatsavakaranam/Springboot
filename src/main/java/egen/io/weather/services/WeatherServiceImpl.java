package egen.io.weather.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import egen.io.weather.details.Weather;
import egen.io.weather.exception.NotFoundException;
import egen.io.weather.repository.WeatherRepo;

@Service
public class WeatherServiceImpl implements WeatherService {

	private WeatherRepo repository;

	public WeatherServiceImpl(WeatherRepo repository) {
		this.repository = repository;
	}

	@Transactional
	public void createWeather(Weather weather) {
		repository.saveWeather(weather);
	}

	@Transactional
	public String findCityWeather(String city, String property) {
		String existing = repository.findCityWeather(city, property);
		if (existing == null) {
			throw new NotFoundException("City Data Not Found");
		}
		return repository.findCityWeather(city, property);
	}

	@Transactional
	public List<Weather> findallcities() {
		return repository.findallcities();
	}

	@Transactional
	public String findbyproperty(String city, String duration, String property) {
		String existing = repository.findbyproperty(city, duration, property);
		if (existing == null) {
			throw new NotFoundException("City Data Not Found");
		}
		return existing;
	}
}
