package platform.codingnomads.co.springweb.resttemplate.GET.getForEntity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.ActivityTemplate;
import platform.codingnomads.co.springweb.resttemplate.GET.models.QuoteTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class GetForEntityDemo {

    @Autowired
    RestTemplate restTemplate;

    public static void main(String[] args) {
        SpringApplication.run(GetForEntityDemo.class, args);
    }

    @Bean
    public CommandLineRunner run() throws Exception {
        return args -> {
            ResponseEntity<QuoteTemplate[]> responseEntity =
                    restTemplate.getForEntity("https://zenquotes.io/api/random", QuoteTemplate[].class);

            if (responseEntity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null) {
                QuoteTemplate[] quoteTemplate = responseEntity.getBody();
                System.out.println(Arrays.toString(quoteTemplate));
            } else {
                System.out.println("Something went wrong! The response was not marked with status code 200");
            }

            Map<String, Integer> params = new HashMap<>();
            params.put("participants",1);
            params.put("price", 0);

            ResponseEntity<ActivityTemplate> responseEntityActivity = restTemplate.getForEntity(
                    "http://www.boredapi.com/api/activity",
                    ActivityTemplate.class,
                    params
            );
            if (responseEntityActivity.getStatusCode().equals(HttpStatus.OK) && responseEntity.getBody() != null){
                ActivityTemplate activity = responseEntityActivity.getBody();
                System.out.println(activity);
            } else{
                System.out.println("ERROR!!!!!");
            }
        };
    }
}
