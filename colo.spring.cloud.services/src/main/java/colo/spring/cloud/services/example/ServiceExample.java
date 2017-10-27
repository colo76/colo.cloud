package colo.spring.cloud.services.example;

import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import colo.spring.cloud.services.domain.Greeting;

@RestController
public class ServiceExample {

	@Value("${message.text}")
	String valueExample = null;

	private static Logger log = LoggerFactory.getLogger(ServiceExample.class);

	private final AtomicLong counter = new AtomicLong();

	private static final String template = "Hello, %s!";

	public ServiceExample() {
		super();
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/message")
	public String example() {

		String result = "{Empty Value}";
		if (valueExample.equals(null)) {

			log.error("PublicRestService - Called with errors property rest.service.cloud.config.example is empty");

		} else {
			log.info("	 - Called with this property: (rest.service.cloud.config.example:" + valueExample + ")");
			result = valueExample;
		}
		return result;
	}

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	public String getValueExample() {
		return valueExample;
	}

	public void setValueExample(String valueExample) {
		this.valueExample = valueExample;
	}
	
	

	
	
}
