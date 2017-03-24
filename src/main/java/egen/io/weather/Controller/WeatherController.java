package egen.io.weather.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import egen.io.weather.details.URI;
import egen.io.weather.details.Weather;
import egen.io.weather.services.WeatherService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = URI.WEATHER)
@ResponseBody
public class WeatherController {

	private WeatherService service;

	public WeatherController(WeatherService service) {
		this.service = service;
	}

	@CrossOrigin(origins = "http://mocker.egen.io/",maxAge=7200)
	@RequestMapping(method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "POST THE DATA", notes = "Just get the data by URL")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public void weather(@RequestBody Weather weather) {
		service.createWeather(weather);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.CITY, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "GET THE DATA BY CITY", notes = "Data of the cities")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public List<Weather> findallcities() {
		return service.findallcities();
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.PRO, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "GET THE DATA OF CITY BY PARAMETER", notes = "Particular data of the city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findone(@PathVariable("city") String city, @PathVariable("property") String property) {
		return service.findCityWeather(city, property);
	}

	@RequestMapping(method = RequestMethod.GET, value = URI.AVG, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	@ApiOperation(value = "GET THE DATA OF CITY BY PARAMETER", notes = "Particular data of the city")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Success"),
			@ApiResponse(code = 500, message = "Internal Server Error"), })
	public String findbyproperty(@PathVariable("city") String city, @PathVariable("duration") String duration,
			@PathVariable("property") String property) {
		return service.findbyproperty(city, duration, property);
	}

}
