package egen.io.weather.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import egen.io.weather.details.Weather;

@Repository
public class WeatherRepository implements WeatherRepo {

	@PersistenceContext
	private EntityManager em;

	WeatherRepository() {
	}

	public void saveWeather(Weather weather) {
		em.persist(weather.getWind());
		em.persist(weather);
	}

	public String findCityWeather(String city, String property) {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findWeatherProperty", Weather.class);
		query.setParameter("city", city);
		List<Weather> weather = query.getResultList();
		if (!weather.isEmpty()) {
			Weather wr = weather.get(0);
			if (property.equalsIgnoreCase("pressure")) {
				return wr.getPressure();
			} else if (property.equalsIgnoreCase("temperature")) {
				return wr.getTemperature();
			} else if (property.equalsIgnoreCase("humidity")) {
				return wr.getHumidity();
			}
		}
		return "Please Check the Parameter";
	}

	public List<Weather> findallcities() {
		TypedQuery<Weather> query = em.createNamedQuery("Weather.findallcities", Weather.class);
		return query.getResultList();
	}

	@Override
	public String findbyproperty(String city, String duration, String property) {

		TypedQuery<Double> query = null;
		if (duration.equalsIgnoreCase("hourly")) {
			if (property.equalsIgnoreCase("pressure")) {
				query = em.createNamedQuery("Weather.findHourlyPressureProperty", Double.class);
			} else if (property.equalsIgnoreCase("temperature")) {
				query = em.createNamedQuery("Weather.findHourlyTemperatureProperty", Double.class);
			} else if (property.equalsIgnoreCase("humidity")) {
				query = em.createNamedQuery("Weather.findHourlyHumidityProperty", Double.class);
			} else {
				return "Please Check the Parameter";
			}
		} else if (duration.equalsIgnoreCase("daily")) {
			if (property.equalsIgnoreCase("pressure")) {
				query = em.createNamedQuery("Weather.findDailyPressureProperty", Double.class);
			} else if (property.equalsIgnoreCase("temperature")) {
				query = em.createNamedQuery("Weather.findDailyTemperatureProperty", Double.class);
			} else if (property.equalsIgnoreCase("humidity")) {
				query = em.createNamedQuery("Weather.findDailyHumidityProperty", Double.class);
			} else {
				return "Please Check the Parameter";
			}
		} else {
			return "Please Check the Parameter";
		}
		query.setParameter("city", city);
		List<Double> weather = query.getResultList();
		if (!weather.isEmpty()) {
			Double avg = weather.get(0);
			System.out.println(avg);
			return avg.toString();
		} else {
			return "No Data Found For this City";
		}
	}

}
