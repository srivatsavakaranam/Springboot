package egen.io.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import egen.io.weather.Controller.WeatherController;
import egen.io.weather.swaggerconfig.SwaggerConfig;

@SpringBootApplication
@Import({SwaggerConfig.class,WebConfiguration.class})
@ComponentScan(basePackageClasses=WeatherController.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		

	}

}
