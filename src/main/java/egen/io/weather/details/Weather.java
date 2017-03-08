package egen.io.weather.details;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({
@NamedQuery(name="Weather.findWeatherProperty", query = "select wea FROM Weather wea where city = :city order by timestamp DESC "),
@NamedQuery(name="Weather.findallcities", query = "SELECT w FROM Weather w WHERE w.timestamp =(SELECT MAX(w.timestamp) FROM Weather w1 WHERE w.city = w.city) AND NOT EXISTS(SELECT w2 FROM Weather w2 WHERE w2.city = w.city AND w2.timestamp > w.timestamp)"),
@NamedQuery(name="Weather.findHourlyPressureProperty",query="SELECT AVG(pressure) as pressure FROM  Weather where city = :city GROUP BY city , HOUR(timestamp)"),
@NamedQuery(name="Weather.findHourlyTemperatureProperty",query="SELECT  AVG(temperature) as temperature FROM  Weather where city = :city GROUP BY city , HOUR(timestamp)"),
@NamedQuery(name="Weather.findHourlyHumidityProperty",query="SELECT AVG(humidity) as humidity FROM  Weather where city = :city GROUP BY city , HOUR(timestamp)"),
@NamedQuery(name="Weather.findDailyPressureProperty",query="SELECT AVG(pressure) as pressure FROM  Weather where city = :city GROUP BY city , DATE(timestamp)"),
@NamedQuery(name="Weather.findDailyTemperatureProperty",query="SELECT  AVG(temperature) as temperature FROM  Weather where city = :city GROUP BY city , DATE(timestamp)"),
@NamedQuery(name="Weather.findDailyHumidityProperty",query="SELECT AVG(humidity) as humidity FROM  Weather where city = :city GROUP BY city , DATE(timestamp)")
})
public class Weather {
	
	private String city;
	private String description;
	private String pressure;
	private String humidity;
	private String temperature;
	private Date timestamp;
	
	@OneToOne
	private Wind wind;
	
	@Id
	private String id;
	
	public Weather(){
		this.id=UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPressure() {
		return pressure;
	}
	public void setPressure(String pressure) {
		this.pressure = pressure;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public Wind getWind() {
		return wind;
	}
	public void setWind(Wind wind) {
		this.wind = wind;
	}
	
}