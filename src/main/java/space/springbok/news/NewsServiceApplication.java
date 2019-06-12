package space.springbok.news;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class NewsServiceApplication {

    @Autowired
    private NewsServiceConfiguration properties;

    @Value("${service.instance.name}")
    private String instance;

    @Value("${some.other.property}")
    private String someOtherProperty;

    public static void main(String[] args) {
        SpringApplication.run(NewsServiceApplication.class, args);
    }

    @RequestMapping("/")
    public String message() {
        return "Hello from instance " + instance;
    }

    @RequestMapping("/printConfig")
    public String printConfig() {
        StringBuilder sb = new StringBuilder();
        sb.append(properties.getProperty());
        sb.append(" || ");
        sb.append(instance);
        sb.append(" || ");
        sb.append(someOtherProperty);

        return sb.toString();
    }

}
